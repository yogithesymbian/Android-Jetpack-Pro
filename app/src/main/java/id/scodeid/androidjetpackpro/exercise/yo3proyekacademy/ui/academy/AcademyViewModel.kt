package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.AcademyRepository
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.CourseEntity

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getCourse(): LiveData<List<CourseEntity>> = academyRepository.getAllCourses()

}