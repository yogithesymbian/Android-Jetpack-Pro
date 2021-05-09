package id.scodeid.yorebahanmovie.ui.home.movie.detail

import androidx.lifecycle.ViewModel
import id.scodeid.yorebahanmovie.entity.MovieEntity
import id.scodeid.yorebahanmovie.utils.DataDummy

class DetailMovieViewModel : ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovieById(): MovieEntity {
        lateinit var movieEntity: MovieEntity
        val dataGenerateDummyMovies = DataDummy.generateDummyMovies()

        for (data in dataGenerateDummyMovies) {
            if (data.movieId == movieId) {
                movieEntity = data
            }
        }

        return movieEntity
    }
}