package id.scodeid.yorebahanmovie.data.source.remote

import android.os.Handler
import android.os.Looper
import id.scodeid.yorebahanmovie.data.source.remote.response.MovieResponse
import id.scodeid.yorebahanmovie.data.source.remote.response.TvShowResponse
import id.scodeid.yorebahanmovie.utils.EspressoIdlingResource
import id.scodeid.yorebahanmovie.utils.JsonHelper
import id.scodeid.yorebahanmovie.utils.TESTING_FLAG
import id.scodeid.yorebahanmovie.utils.TESTING_FLAG_MATCH

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 1000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(responses: List<MovieResponse>)
    }

    fun getAllMovies(callback: LoadMoviesCallback) {

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        handler.postDelayed({
            callback.onAllMoviesReceived(jsonHelper.loadMovies())

            if (TESTING_FLAG == TESTING_FLAG_MATCH)
                if (!EspressoIdlingResource.idLingResource.isIdleNow)
                    EspressoIdlingResource.decrement()

        }, SERVICE_LATENCY_IN_MILLIS)

    }

    interface LoadTvShowCallback {
        fun onAllTvShowReceived(responses: List<TvShowResponse>)
    }

    fun getAllTvShow(callback: LoadTvShowCallback) {

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        handler.postDelayed({
            callback.onAllTvShowReceived(jsonHelper.loadTvShow())

            if (TESTING_FLAG == TESTING_FLAG_MATCH)
                if (!EspressoIdlingResource.idLingResource.isIdleNow)
                    EspressoIdlingResource.decrement()

        }, SERVICE_LATENCY_IN_MILLIS)

    }


}