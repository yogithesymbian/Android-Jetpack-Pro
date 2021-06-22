package id.scodeid.yorebahanmovie.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.scodeid.yorebahanmovie.data.source.YoMovieRepository
import id.scodeid.yorebahanmovie.di.Injection
import id.scodeid.yorebahanmovie.ui.home.movie.MovieViewModel
import id.scodeid.yorebahanmovie.ui.home.movie.detail.DetailMovieViewModel
import id.scodeid.yorebahanmovie.ui.home.tvshow.TvShowViewModel
import id.scodeid.yorebahanmovie.ui.home.tvshow.detail.DetailTvShowViewModel

class ViewModelFactory private constructor(private val yoMovieRepository: YoMovieRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(yoMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(yoMovieRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(yoMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                DetailTvShowViewModel(yoMovieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }


}