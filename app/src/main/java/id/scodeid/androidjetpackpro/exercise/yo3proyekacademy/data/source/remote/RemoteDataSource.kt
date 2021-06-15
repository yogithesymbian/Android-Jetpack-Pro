package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote

import android.os.Handler
import android.os.Looper
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote.response.ContentResponse
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote.response.CourseResponse
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote.response.ModuleResponse
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.EspressoIdlingResource
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.JsonHelper
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.TESTING_FLAG
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.TESTING_FLAG_MATCH

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instances: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instances ?: synchronized(this) {
                instances ?: RemoteDataSource(helper).apply {
                    instances = this
                }
            }
    }

//    fun getAllCourses(): List<CourseResponse> = jsonHelper.loadCourses()

    fun getAllCourses(callback: LoadCoursesCallback) {

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        handler.postDelayed({
            callback.onAllCoursesReceived(jsonHelper.loadCourses())

            if (TESTING_FLAG == TESTING_FLAG_MATCH)
                if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                    EspressoIdlingResource.decrement()

        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadCoursesCallback {
        fun onAllCoursesReceived(courseResponse: List<CourseResponse>)
    }

//    fun getModules(courseId: String): List<ModuleResponse> = jsonHelper.loadModule(courseId)

    fun getModules(courseId: String, callback: LoadModulesCallback) {

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        handler.postDelayed({
            callback.onAllModulesReceived(jsonHelper.loadModule(courseId))

            if (TESTING_FLAG == TESTING_FLAG_MATCH)
                if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                    EspressoIdlingResource.decrement()

        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadModulesCallback {
        fun onAllModulesReceived(moduleResponse: List<ModuleResponse>)
    }

//    fun getContent(moduleId: String): ContentResponse = jsonHelper.loadContent(moduleId)

    fun getContent(moduleId: String, callback: LoadContentCallback) {

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        handler.postDelayed({
            callback.onContentReceived(jsonHelper.loadContent(moduleId))

            if (TESTING_FLAG == TESTING_FLAG_MATCH)
                if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                    EspressoIdlingResource.decrement()

        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadContentCallback {
        fun onContentReceived(contentResponse: ContentResponse)
    }
}