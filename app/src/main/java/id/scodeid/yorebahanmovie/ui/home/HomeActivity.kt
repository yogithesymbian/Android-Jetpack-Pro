package id.scodeid.yorebahanmovie.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding

    private val tabIcons = intArrayOf(
            R.drawable.ic_tv,
            R.drawable.ic_movie,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding view
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)
        setSupportActionBar(activityHomeBinding.toolbarHome)
        activityHomeBinding.toolbarHome.setNavigationOnClickListener {
            Toast.makeText(this, "Feature is Under Construction", Toast.LENGTH_SHORT).show()
        }

        // config tabs layout
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityHomeBinding.viewPager.adapter = sectionsPagerAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)
        supportActionBar?.elevation = 0f
        setTabIcons()

    }

    private fun setTabIcons() { // set by position tab - ascending
        tabIcons.let {
            for (i in it.indices) {
                activityHomeBinding.tabs.getTabAt(i)?.setIcon(it[i])
            }
        }
    }

    // config set option menu on toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // menu | actionbar trigger
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_config -> {
                Toast.makeText(this, getString(R.string.home_activity), Toast.LENGTH_LONG).show()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}