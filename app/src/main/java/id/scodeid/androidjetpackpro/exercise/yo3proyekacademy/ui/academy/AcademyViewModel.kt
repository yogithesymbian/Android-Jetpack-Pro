package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.academy

import androidx.lifecycle.ViewModel
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity.CourseEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.DataDummy

class AcademyViewModel : ViewModel(){

    fun getCourse(): List<CourseEntity> = DataDummy.generateDummyCourses()
}