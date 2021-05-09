package id.scodeid.yorebahanmovie.ui.home.movie

import androidx.lifecycle.ViewModel
import id.scodeid.yorebahanmovie.entity.MovieEntity
import id.scodeid.yorebahanmovie.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovies()
}