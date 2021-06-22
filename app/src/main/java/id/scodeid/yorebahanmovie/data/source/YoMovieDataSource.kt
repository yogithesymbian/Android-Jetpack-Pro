package id.scodeid.yorebahanmovie.data.source

import id.scodeid.yorebahanmovie.data.source.local.entity.MovieEntity
import id.scodeid.yorebahanmovie.data.source.local.entity.TvShowEntity

interface YoMovieDataSource {

    fun getAllMovies(): List<MovieEntity>
    fun getMovie(movieId: String): MovieEntity

    fun getAllTvShow(): List<TvShowEntity>
    fun getTvShow(tvShowId: String): TvShowEntity

}