package id.scodeid.yorebahanmovie.data.source

import android.graphics.drawable.Drawable
import id.scodeid.yorebahanmovie.data.source.local.entity.MovieEntity
import id.scodeid.yorebahanmovie.data.source.local.entity.TvShowEntity
import id.scodeid.yorebahanmovie.data.source.remote.RemoteDataSource


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

    override fun getAllMovies(): ArrayList<MovieEntity> {
        val responses = remoteDataSource.getAllMovies()
        val arrMovie = ArrayList<MovieEntity>()
        for (res in responses) {
            val course = MovieEntity(
                res.movieId,
                res.bookmarked,
                res.imgPath,
                res.title,
                res.rating,
                res.date,
                res.genre,
                res.videoTime,
                res.description,
                res.cuanValue,
                res.videoScore,
                res.status,
                res.director,
                res.language,
                res.budget,
                res.income,
                res.adult,
            )
            arrMovie.add(course)
        }
        return arrMovie
    }

    override fun getMovie(movieId: String): MovieEntity {
        val responses = remoteDataSource.getAllMovies()
        lateinit var movieEntity: MovieEntity
        for (res in responses) {
            if (res.movieId == movieId) {
                movieEntity = MovieEntity(
                    res.movieId,
                    res.bookmarked,
                    res.imgPath,
                    res.title,
                    res.rating,
                    res.date,
                    res.genre,
                    res.videoTime,
                    res.description,
                    res.cuanValue,
                    res.videoScore,
                    res.status,
                    res.director,
                    res.language,
                    res.budget,
                    res.income,
                    res.adult,
                )
            }
        }
        return movieEntity
    }

    override fun getAllTvShow(): ArrayList<TvShowEntity> {
        val responses = remoteDataSource.getAllTvShow()
        val arrTvShow = ArrayList<TvShowEntity>()
        for (res in responses) {
            val tvShowEntity = TvShowEntity(
                res.tvShowId,
                res.bookmarked,
                res.imgPath,
                res.title,
                res.rating,
                res.date,
                res.genre,
                res.videoTime,
                res.description,
                res.cuanValue,
                res.videoScore,
                res.status,
                res.creator,
                res.language,
                res.type,
                res.adult,
            )
            arrTvShow.add(tvShowEntity)
        }
        return arrTvShow
    }
    override fun getTvShow(tvShowId: String): TvShowEntity {
        val responses = remoteDataSource.getAllTvShow()
        lateinit var tvShowEntity: TvShowEntity
        for (res in responses) {
            if (res.tvShowId == tvShowId) {
                tvShowEntity = TvShowEntity(
                    res.tvShowId,
                    res.bookmarked,
                    res.imgPath,
                    res.title,
                    res.rating,
                    res.date,
                    res.genre,
                    res.videoTime,
                    res.description,
                    res.cuanValue,
                    res.videoScore,
                    res.status,
                    res.creator,
                    res.language,
                    res.type,
                    res.adult,
                )
            }
        }
        return tvShowEntity
    }
}