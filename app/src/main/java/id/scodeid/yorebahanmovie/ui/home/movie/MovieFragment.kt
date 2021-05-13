package id.scodeid.yorebahanmovie.ui.home.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.databinding.FragmentMovieBinding

class MovieFragment() : Fragment() {

    // init binding view
    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
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
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]

            // set adapter and load a manipulation data
            val academyAdapter = MovieAdapter()
            academyAdapter.setMovies(viewModel.getMovies())

            // config recyclerView for the data
            with(fragmentMovieBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = academyAdapter
            }
        }
    }

}