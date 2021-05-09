package id.scodeid.yorebahanmovie.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.ui.home.movie.MovieFragment
import id.scodeid.yorebahanmovie.ui.home.tvshow.TvShowFragment

class SectionsPagerAdapter(
    private val context: Context, fragmentManager: FragmentManager
) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.home_movie, R.string.home_tv)
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence =
        context.resources.getString(TAB_TITLES[position])

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieFragment()
            1 -> TvShowFragment()
            else -> Fragment()
        }
}