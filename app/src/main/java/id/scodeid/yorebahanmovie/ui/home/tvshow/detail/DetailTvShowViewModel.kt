package id.scodeid.yorebahanmovie.ui.home.tvshow.detail

import androidx.lifecycle.ViewModel
import id.scodeid.yorebahanmovie.entity.TvShowEntity
import id.scodeid.yorebahanmovie.utils.DataDummy

class DetailTvShowViewModel : ViewModel() {
    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShowById(): TvShowEntity {
        lateinit var tvShowEntity: TvShowEntity
        val dataGenerateDummyMovies = DataDummy.generateDummyTvShow()

        for (data in dataGenerateDummyMovies) {
            if (data.tvShowId == tvShowId) {
                tvShowEntity = data
            }
        }

        return tvShowEntity
    }
}