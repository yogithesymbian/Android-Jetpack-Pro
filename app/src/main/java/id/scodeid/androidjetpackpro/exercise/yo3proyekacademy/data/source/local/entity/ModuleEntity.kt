package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity

data class ModuleEntity(
    var moduleId: String,
    var courseId: String,
    var title: String,
    var positiion: Int,
    var read: Boolean = false
) {
    var contentEntity: ContentEntity? = null
}