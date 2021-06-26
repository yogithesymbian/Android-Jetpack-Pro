package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity

import androidx.room.*

data class CourseWithModule (
    @Embedded
    var courseEntity: CourseEntity,
    @Relation(parentColumn = "courseId", entityColumn = "courseId")
    var modules: List<ModuleEntity>
)