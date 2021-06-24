package id.scodeid.yorebahanmovie.ui.home.tvshow.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.scodeid.yorebahanmovie.data.source.YoMovieRepository
import id.scodeid.yorebahanmovie.data.source.local.entity.TvShowEntity

class DetailTvShowViewModel(private val yoMovieRepository: YoMovieRepository) : ViewModel() {
    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShowById(): LiveData<TvShowEntity> = yoMovieRepository.getTvShow(tvShowId)
}