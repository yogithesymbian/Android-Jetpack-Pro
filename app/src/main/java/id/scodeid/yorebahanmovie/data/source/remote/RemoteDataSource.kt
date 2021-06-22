package id.scodeid.yorebahanmovie.data.source.remote

import id.scodeid.yorebahanmovie.data.source.remote.response.MovieResponse
import id.scodeid.yorebahanmovie.data.source.remote.response.TvShowResponse
import id.scodeid.yorebahanmovie.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(): List<MovieResponse> = jsonHelper.loadMovies()

    fun getAllTvShow(): List<TvShowResponse> = jsonHelper.loadTvShow()


}