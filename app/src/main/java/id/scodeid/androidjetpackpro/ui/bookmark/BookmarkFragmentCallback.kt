package id.scodeid.androidjetpackpro.ui.bookmark

import id.scodeid.androidjetpackpro.entity.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(courseEntity: CourseEntity)
}
