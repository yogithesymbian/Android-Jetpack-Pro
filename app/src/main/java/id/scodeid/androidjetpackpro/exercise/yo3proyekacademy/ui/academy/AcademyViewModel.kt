package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.AcademyRepository
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.CourseEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.EspressoIdlingResource
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.*

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getCourse(): LiveData<List<CourseEntity>> {
        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        val data = academyRepository.getAllCourses()

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                EspressoIdlingResource.decrement()

        return data
    }
}