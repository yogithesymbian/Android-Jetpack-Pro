package id.scodeid.yorebahanmovie.ui.home.tvshow

import androidx.lifecycle.ViewModel
import id.scodeid.yorebahanmovie.entity.TvShowEntity
import id.scodeid.yorebahanmovie.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShow()
}