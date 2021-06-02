package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity


data class CourseEntity(
    var courseId: String,
    var title: String,
    var description: String,
    var deadline: String,
    var bookmarked: Boolean = false,
    var imagePath: String
)