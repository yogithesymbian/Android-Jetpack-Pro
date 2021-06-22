package id.scodeid.yorebahanmovie.ui.home.tvshow

import androidx.lifecycle.ViewModel
import id.scodeid.yorebahanmovie.data.source.YoMovieRepository
import id.scodeid.yorebahanmovie.data.source.local.entity.TvShowEntity

class TvShowViewModel(private val yoMovieRepository: YoMovieRepository) : ViewModel() {
    fun getTvShow(): List<TvShowEntity> = yoMovieRepository.getAllTvShow()
}