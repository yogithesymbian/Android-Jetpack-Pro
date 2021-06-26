package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.bookmark

import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(courseEntity: CourseEntity)
}
