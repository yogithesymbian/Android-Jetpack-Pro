package id.scodeid.yorebahanmovie.ui.home.movie.detail

import androidx.lifecycle.ViewModel
import id.scodeid.yorebahanmovie.entity.MovieEntity
import id.scodeid.yorebahanmovie.utils.DataDummy
import id.scodeid.yorebahanmovie.utils.EspressoIdlingResource
import id.scodeid.yorebahanmovie.utils.TESTING_FLAG
import id.scodeid.yorebahanmovie.utils.TESTING_FLAG_MATCH

class DetailMovieViewModel : ViewModel() {

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovieById(): MovieEntity {

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        lateinit var movieEntity: MovieEntity
        val dataGenerateDummyMovies = DataDummy.generateDummyMovies()

        for (data in dataGenerateDummyMovies) {
            if (data.movieId == movieId) {
                movieEntity = data
            }
        }

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            if (!EspressoIdlingResource.idLingResource.isIdleNow)
                EspressoIdlingResource.decrement()

        return movieEntity
    }
}