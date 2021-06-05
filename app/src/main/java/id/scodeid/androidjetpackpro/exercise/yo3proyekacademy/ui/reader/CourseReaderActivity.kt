package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.reader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import id.scodeid.androidjetpackpro.R
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.reader.content.ModuleListFragment
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.reader.list.ModuleContentFragment
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.viewmodel.ViewModelFactory

class CourseReaderActivity : AppCompatActivity(), CourseReaderCallback {
    companion object {
        const val EXTRA_COURSE_ID = "extra_course_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_reader)

        val viewModelFactory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, viewModelFactory)[CourseReaderViewModel::class.java]

        val bundle = intent.extras
        if (bundle != null) {
            val courseId = bundle.getString(EXTRA_COURSE_ID)
            if (courseId != null) {
                viewModel.setSelectedCourse(courseId)
                populateFragment()
            }
        }
    }

    private fun populateFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(ModuleListFragment.TAG)

        if (fragment == null) {
            fragment = ModuleListFragment.newInstance()
            fragmentTransaction.add(R.id.frame_container, fragment, ModuleListFragment.TAG)
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }

    override fun moveTo(position: Int, moduleId: String) {
        val moduleContentFragment = ModuleContentFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.frame_container, moduleContentFragment, ModuleContentFragment.TAG)
                .addToBackStack(null)
                .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}