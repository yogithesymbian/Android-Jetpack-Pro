package id.scodeid.yorebahanmovie.ui.home.tvshow

import androidx.lifecycle.ViewModel
import id.scodeid.yorebahanmovie.entity.TvShowEntity
import id.scodeid.yorebahanmovie.utils.DataDummy
import id.scodeid.yorebahanmovie.utils.EspressoIdlingResource
import id.scodeid.yorebahanmovie.utils.TESTING_FLAG
import id.scodeid.yorebahanmovie.utils.TESTING_FLAG_MATCH

class TvShowViewModel : ViewModel() {
    fun getTvShow(): List<TvShowEntity> {

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        val generate = DataDummy.generateDummyTvShow()

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            if (!EspressoIdlingResource.idLingResource.isIdleNow)
                EspressoIdlingResource.decrement()

        return generate
    }
}