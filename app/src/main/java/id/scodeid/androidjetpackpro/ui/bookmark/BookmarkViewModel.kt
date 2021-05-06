package id.scodeid.androidjetpackpro.ui.bookmark

import androidx.lifecycle.ViewModel
import id.scodeid.androidjetpackpro.entity.CourseEntity
import id.scodeid.androidjetpackpro.utils.DataDummy

class BookmarkViewModel : ViewModel() {

    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}