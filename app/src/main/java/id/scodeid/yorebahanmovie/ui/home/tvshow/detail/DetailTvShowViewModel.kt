package id.scodeid.yorebahanmovie.ui.home.tvshow.detail

import androidx.lifecycle.ViewModel
import id.scodeid.yorebahanmovie.entity.TvShowEntity
import id.scodeid.yorebahanmovie.utils.DataDummy
import id.scodeid.yorebahanmovie.utils.EspressoIdlingResource
import id.scodeid.yorebahanmovie.utils.TESTING_FLAG
import id.scodeid.yorebahanmovie.utils.TESTING_FLAG_MATCH

class DetailTvShowViewModel : ViewModel() {
    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShowById(): TvShowEntity {

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        lateinit var tvShowEntity: TvShowEntity
        val dataGenerateDummyMovies = DataDummy.generateDummyTvShow()

        for (data in dataGenerateDummyMovies) {
            if (data.tvShowId == tvShowId) {
                tvShowEntity = data
            }
        }

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            if (!EspressoIdlingResource.idLingResource.isIdleNow)
                EspressoIdlingResource.decrement()

        return tvShowEntity
    }
}