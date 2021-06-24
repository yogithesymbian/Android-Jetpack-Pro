package id.scodeid.yorebahanmovie.ui.home.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.databinding.FragmentMovieBinding
import id.scodeid.yorebahanmovie.data.source.local.entity.MovieEntity
import id.scodeid.yorebahanmovie.utils.*
import id.scodeid.yorebahanmovie.viewmodel.ViewModelFactory

class MovieFragment : Fragment(), MovieFragmentCallback {

    // init binding view
    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            view.setBackgroundColor(
                ResourcesCompat.getColor(
                    resources,
                    R.color.white,
                    null
                )
            )

            // init viewModel
            val viewModelFactory = ViewModelFactory.getInstance(requireContext())
            val viewModel = ViewModelProvider(this,
                viewModelFactory)[MovieViewModel::class.java]

            // set adapter and load a manipulation data
            val movieAdapter = MovieAdapter(this)
            fragmentMovieBinding.progressBar.visible()

            viewModel.getMovies().observe(viewLifecycleOwner, { movie ->
                fragmentMovieBinding.progressBar.gone()
                movieAdapter.setMovies(movie, this)
                movieAdapter.notifyDataSetChanged()
                if (movieAdapter.itemCount == 0) hideRv()
                else showRv()
            })

            // config recyclerView for the data
            with(fragmentMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }

        }
    }

    private fun showRv() {
        fragmentMovieBinding.let {
            it.rvMovie.visible()
            it.emptyContent.root.gone()
        }
    }

    private fun hideRv() {
        fragmentMovieBinding.let {
            it.rvMovie.gone()
            it.emptyContent.root.visible()
        }
    }

    override fun onShareClick(movieEntity: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang")
                .setText(resources.getString(R.string.share_text,
                    movieEntity.title,
                    movieEntity.cuanValue))
                .startChooser()
        }
    }

    override fun onVidScoreClick(movieEntity: MovieEntity, view: View) {
        view.showSnackBar(resources.getString(
            R.string.detail_movie_activity_video_score,
            movieEntity.videoScore
        ), Snackbar.LENGTH_SHORT)
    }

    override fun onCheckDataSize(size: Int?) {
        fragmentMovieBinding.let {
            if (dataFailOnLoad == getString(R.string.testDataFailOnLoad)) {
                it.rvMovie.gone()
                it.failedLoadContent.root.visible()
            }
        }
    }

    companion object {
        val TAG_LOG: String = MovieFragment::class.java.simpleName
    }

}