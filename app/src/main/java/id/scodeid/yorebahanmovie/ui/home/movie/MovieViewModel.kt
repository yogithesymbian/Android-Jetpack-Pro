package id.scodeid.yorebahanmovie.ui.home.movie

import androidx.lifecycle.ViewModel
import id.scodeid.yorebahanmovie.data.source.YoMovieRepository
import id.scodeid.yorebahanmovie.data.source.local.entity.MovieEntity

class MovieViewModel(private val yoMovieRepository: YoMovieRepository) : ViewModel() {
    fun getMovies(): List<MovieEntity> = yoMovieRepository.getAllMovies()
}