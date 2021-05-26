package id.scodeid.yorebahanmovie.ui.home.movie

import androidx.lifecycle.ViewModel
import id.scodeid.yorebahanmovie.entity.MovieEntity
import id.scodeid.yorebahanmovie.utils.DataDummy
import id.scodeid.yorebahanmovie.utils.EspressoIdlingResource
import id.scodeid.yorebahanmovie.utils.TESTING_FLAG
import id.scodeid.yorebahanmovie.utils.TESTING_FLAG_MATCH

class MovieViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> {
        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        val generate = DataDummy.generateDummyMovies()

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            if (!EspressoIdlingResource.idLingResource.isIdleNow)
                EspressoIdlingResource.decrement()

        return generate
    }
}