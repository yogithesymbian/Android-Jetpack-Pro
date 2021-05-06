package id.scodeid.androidjetpackpro.ui.academy

import androidx.lifecycle.ViewModel
import id.scodeid.androidjetpackpro.entity.CourseEntity
import id.scodeid.androidjetpackpro.utils.DataDummy

class AcademyViewModel : ViewModel(){

    fun getCourse(): List<CourseEntity> = DataDummy.generateDummyCourses()
}