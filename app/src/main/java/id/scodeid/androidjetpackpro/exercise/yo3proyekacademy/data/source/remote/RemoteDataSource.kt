package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote

import android.os.Handler
import android.os.Looper
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote.response.ContentResponse
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote.response.CourseResponse
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote.response.ModuleResponse
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    private val handler = Handler(Looper.getMainLooper())

    companion object{

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instances: RemoteDataSource? =null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instances ?: synchronized(this) {
                instances ?: RemoteDataSource(helper).apply {
                    instances = this
                }
            }
    }

//    fun getAllCourses(): List<CourseResponse> = jsonHelper.loadCourses()

    fun getAllCourses(callback: LoadCoursesCallback) {
        handler.postDelayed({ callback.onAllCoursesReceived(jsonHelper.loadCourses())}, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadCoursesCallback {
        fun onAllCoursesReceived(courseResponse: List<CourseResponse>)
    }

//    fun getModules(courseId: String): List<ModuleResponse> = jsonHelper.loadModule(courseId)

    fun getModules(courseId: String, callback: LoadModulesCallback) {
        handler.postDelayed({callback.onAllModulesReceived(jsonHelper.loadModule(courseId))}, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadModulesCallback {
        fun onAllModulesReceived(moduleResponse: List<ModuleResponse>)
    }

//    fun getContent(moduleId: String): ContentResponse = jsonHelper.loadContent(moduleId)

    fun getContent(moduleId: String, callback: LoadContentCallback) {
        handler.postDelayed({ callback.onContentReceived(jsonHelper.loadContent(moduleId)) }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadContentCallback {
        fun onContentReceived(contentResponse: ContentResponse)
    }
}