package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.bookmark

import androidx.lifecycle.ViewModel
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity.CourseEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.DataDummy

class BookmarkViewModel : ViewModel() {

    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}