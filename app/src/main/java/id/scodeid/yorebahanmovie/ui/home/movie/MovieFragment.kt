package id.scodeid.yorebahanmovie.ui.home.movie

import android.os.Bundle
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
import id.scodeid.yorebahanmovie.entity.MovieEntity
import id.scodeid.yorebahanmovie.utils.showSnackBar

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
            val viewModel = ViewModelProvider(this,
                ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]

            // set adapter and load a manipulation data
            val academyAdapter = MovieAdapter(this)
            academyAdapter.setMovies(viewModel.getMovies())

            // config recyclerView for the data
            with(fragmentMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = academyAdapter
            }
        }
    }

    override fun onShareClick(movieEntity: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang")
                .setText(resources.getString(R.string.share_text, movieEntity.title))
                .startChooser()
        }
    }

    override fun onVidScoreClick(movieEntity: MovieEntity, view: View) {
        view.showSnackBar(resources.getString(
            R.string.detail_movie_activity_video_score,
            movieEntity.videoScore
        ), Snackbar.LENGTH_SHORT)
    }

}