package id.scodeid.yorebahanmovie.data.source

import androidx.lifecycle.LiveData
import id.scodeid.yorebahanmovie.data.source.local.entity.MovieEntity
import id.scodeid.yorebahanmovie.data.source.local.entity.TvShowEntity

interface YoMovieDataSource {

    fun getAllMovies(): LiveData<List<MovieEntity>>
    fun getMovie(movieId: String): LiveData<MovieEntity>

    fun getAllTvShow(): LiveData<List<TvShowEntity>>
    fun getTvShow(tvShowId: String): LiveData<TvShowEntity>

}