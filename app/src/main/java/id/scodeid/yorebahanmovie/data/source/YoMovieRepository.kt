package id.scodeid.yorebahanmovie.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.scodeid.yorebahanmovie.data.source.local.entity.MovieEntity
import id.scodeid.yorebahanmovie.data.source.local.entity.TvShowEntity
import id.scodeid.yorebahanmovie.data.source.remote.RemoteDataSource
import id.scodeid.yorebahanmovie.data.source.remote.response.MovieResponse
import id.scodeid.yorebahanmovie.data.source.remote.response.TvShowResponse


class YoMovieRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    YoMovieDataSource {
    companion object {
        @Volatile
        private var instance: YoMovieRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): YoMovieRepository =
            instance ?: synchronized(this) {
                instance ?: YoMovieRepository(remoteDataSource).apply {
                    instance = this
                }
            }
    }

    override fun getAllMovies(): LiveData<List<MovieEntity>> {

        val mutableLiveData = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback{
            override fun onAllMoviesReceived(responses: List<MovieResponse>) {

                val arrListMovie = ArrayList<MovieEntity>()

                for (res in responses) {
                    val movieEntity = MovieEntity(
                        res.movieId, res.bookmarked,
                        res.imgPath, res.title,
                        res.rating, res.date,
                        res.genre, res.videoTime,
                        res.description, res.cuanValue,
                        res.videoScore, res.status,
                        res.director, res.language,
                        res.budget, res.income,
                        res.adult,
                    )
                    arrListMovie.add(movieEntity)
                }

                mutableLiveData.postValue(arrListMovie)
            }
        })

        return mutableLiveData
    }

    override fun getMovie(movieId: String): LiveData<MovieEntity> {

        val mutableLiveData = MutableLiveData<MovieEntity>()

        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(responses: List<MovieResponse>) {

                lateinit var movieEntity: MovieEntity
                for (res in responses) {
                    if (res.movieId == movieId) {
                        movieEntity = MovieEntity(
                            res.movieId, res.bookmarked,
                            res.imgPath, res.title,
                            res.rating, res.date,
                            res.genre, res.videoTime,
                            res.description, res.cuanValue,
                            res.videoScore, res.status,
                            res.director, res.language,
                            res.budget, res.income,
                            res.adult,
                        )
                    }
                }

                mutableLiveData.postValue(movieEntity)
            }
        })

        return mutableLiveData
    }

    override fun getAllTvShow(): LiveData<List<TvShowEntity>> {

        val mutableLiveData = MutableLiveData<List<TvShowEntity>>()

        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(responses: List<TvShowResponse>) {

                val arrListTvShow = ArrayList<TvShowEntity>()

                for (res in responses) {
                    val tvShowEntity = TvShowEntity(
                        res.tvShowId, res.bookmarked,
                        res.imgPath, res.title,
                        res.rating, res.date,
                        res.genre, res.videoTime,
                        res.description, res.cuanValue,
                        res.videoScore, res.status,
                        res.creator, res.language,
                        res.type, res.adult,
                    )
                    arrListTvShow.add(tvShowEntity)
                }

                mutableLiveData.postValue(arrListTvShow)
            }
        })

        return mutableLiveData
    }
    override fun getTvShow(tvShowId: String): LiveData<TvShowEntity> {

        val mutableLiveData = MutableLiveData<TvShowEntity>()

        remoteDataSource.getAllTvShow(object : RemoteDataSource.LoadTvShowCallback{
            override fun onAllTvShowReceived(responses: List<TvShowResponse>) {

                lateinit var tvShowEntity: TvShowEntity
                for (res in responses) {
                    if (res.tvShowId == tvShowId) {
                        tvShowEntity = TvShowEntity(
                            res.tvShowId, res.bookmarked,
                            res.imgPath, res.title,
                            res.rating, res.date,
                            res.genre, res.videoTime,
                            res.description, res.cuanValue,
                            res.videoScore, res.status,
                            res.creator, res.language,
                            res.type, res.adult,
                        )
                    }
                }

                mutableLiveData.postValue(tvShowEntity)
            }
        })

        return mutableLiveData
    }
}