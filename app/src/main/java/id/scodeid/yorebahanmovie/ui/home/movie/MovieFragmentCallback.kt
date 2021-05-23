package id.scodeid.yorebahanmovie.ui.home.movie

import android.view.View
import id.scodeid.yorebahanmovie.entity.MovieEntity

interface MovieFragmentCallback {
    fun onShareClick(movieEntity: MovieEntity)
    fun onVidScoreClick(movieEntity: MovieEntity, view: View)
}
