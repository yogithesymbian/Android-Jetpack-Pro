package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.detail

import androidx.lifecycle.ViewModel
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.AcademyRepository
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.CourseEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.ModuleEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.DataDummy

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity = academyRepository.getCourseWithModules(courseId)

    fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)
}