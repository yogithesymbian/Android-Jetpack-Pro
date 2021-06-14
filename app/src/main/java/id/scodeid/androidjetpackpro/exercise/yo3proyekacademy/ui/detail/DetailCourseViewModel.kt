package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.AcademyRepository
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.CourseEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.ModuleEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.DataDummy
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.EspressoIdlingResource
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.TESTING_FLAG
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.TESTING_FLAG_MATCH

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): LiveData<CourseEntity>{

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        val data = academyRepository.getCourseWithModules(courseId)

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                EspressoIdlingResource.decrement()

        return data
    }

    fun getModules(): LiveData<List<ModuleEntity>>{

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        val data = academyRepository.getAllModulesByCourse(courseId)

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                EspressoIdlingResource.decrement()

        return data
    }
}