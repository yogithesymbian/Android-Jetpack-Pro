package id.scodeid.yorebahanmovie.ui.home.tvshow

import id.scodeid.yorebahanmovie.data.source.local.entity.TvShowEntity

interface TvShowFragmentCallback {
    fun onShareClick(tvShowEntity: TvShowEntity)
    fun onCheckDataSize(size: Int?)
}
