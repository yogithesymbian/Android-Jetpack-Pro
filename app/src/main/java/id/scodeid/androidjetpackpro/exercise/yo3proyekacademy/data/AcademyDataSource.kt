package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data

import androidx.lifecycle.LiveData
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity.CourseEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity.CourseWithModule
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity.ModuleEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.vo.Resource

interface AcademyDataSource {

    fun getAllCourses(): LiveData<Resource<List<CourseEntity>>>

    fun getCourseWithModules(courseId: String): LiveData<Resource<CourseWithModule>>

    fun getAllModulesByCourse(courseId: String): LiveData<Resource<List<ModuleEntity>>>

    fun getContent(moduleId: String): LiveData<Resource<ModuleEntity>>

    fun getBookmarkedCourses(): LiveData<List<CourseEntity>>

    fun setCourseBookmark(course: CourseEntity, state: Boolean)
    fun setReadModule(module: ModuleEntity)
}