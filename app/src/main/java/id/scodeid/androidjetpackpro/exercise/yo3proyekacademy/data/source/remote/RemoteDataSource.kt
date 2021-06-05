package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote

import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote.response.ContentResponse
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote.response.CourseResponse
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote.response.ModuleResponse
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    companion object{
        @Volatile
        private var instances: RemoteDataSource? =null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instances ?: synchronized(this) {
                instances ?: RemoteDataSource(helper).apply {
                    instances = this
                }
            }
    }

    fun getAllCourses(): List<CourseResponse> = jsonHelper.loadCourses()

    fun getModules(courseId: String): List<ModuleResponse> = jsonHelper.loadModule(courseId)

    fun getContent(moduleId: String): ContentResponse = jsonHelper.loadContent(moduleId)
}