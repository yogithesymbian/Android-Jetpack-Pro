package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.reader

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.AcademyRepository
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.ContentEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.ModuleEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.DataDummy
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.EspressoIdlingResource
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.TESTING_FLAG
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.TESTING_FLAG_MATCH

class CourseReaderViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    private lateinit var courseId: String
    private lateinit var moduleId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun setSelectedModule(moduleId: String) {
        this.moduleId = moduleId
    }

    fun getModules(): LiveData<List<ModuleEntity>> {

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        val data = academyRepository.getAllModulesByCourse(courseId)

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                EspressoIdlingResource.decrement()

        return data
    }

    fun getSelectedModule(): LiveData<ModuleEntity> {

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        val data = academyRepository.getContent(courseId, moduleId)

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                EspressoIdlingResource.decrement()

        return data
    }
}