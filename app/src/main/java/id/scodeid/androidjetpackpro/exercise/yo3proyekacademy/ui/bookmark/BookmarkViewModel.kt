package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.AcademyRepository
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.CourseEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.DataDummy
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.EspressoIdlingResource
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.TESTING_FLAG
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.TESTING_FLAG_MATCH

class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getBookmarks(): LiveData<List<CourseEntity>>{

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        val data = academyRepository.getBookmarkedCourses()

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                EspressoIdlingResource.decrement()

        return data
    }
}