package id.scodeid.androidjetpackpro.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.scodeid.androidjetpackpro.R
import id.scodeid.androidjetpackpro.ui.academy.AcademyFragment
import id.scodeid.androidjetpackpro.ui.bookmark.BookmarkFragment

class SectionsPagerAdapter(
        private val context: Context, fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.home, R.string.bookmark)
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence = context.resources.getString(TAB_TITLES[position])

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> AcademyFragment()
                1 -> BookmarkFragment()
                else -> Fragment()
            }
}