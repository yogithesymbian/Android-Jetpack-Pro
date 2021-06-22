package id.scodeid.yorebahanmovie.ui.home.movie

import android.view.View
import id.scodeid.yorebahanmovie.data.source.local.entity.MovieEntity

interface MovieFragmentCallback {
    fun onShareClick(movieEntity: MovieEntity)
    fun onVidScoreClick(movieEntity: MovieEntity, view: View)
    fun onCheckDataSize(size: Int?)
}
