package id.scodeid.yorebahanmovie.ui.home.movie.detail

import androidx.lifecycle.ViewModel
import id.scodeid.yorebahanmovie.data.source.YoMovieRepository
import id.scodeid.yorebahanmovie.data.source.local.entity.MovieEntity

class DetailMovieViewModel(private val yoMovieRepository: YoMovieRepository) : ViewModel() {

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovieById(): MovieEntity = yoMovieRepository.getMovie(movieId)
}