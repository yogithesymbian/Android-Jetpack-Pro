package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun getAllCourses(): LiveData<ApiResponse<List<CourseResponse>>> {

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        val resultCourse = MutableLiveData<ApiResponse<List<CourseResponse>>>()

        handler.postDelayed({
            resultCourse.value = ApiResponse.success(jsonHelper.loadCourses())

            if (TESTING_FLAG == TESTING_FLAG_MATCH)
                if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                    EspressoIdlingResource.decrement()

        }, SERVICE_LATENCY_IN_MILLIS)
        return resultCourse
    }

    fun getModules(courseId: String): LiveData<ApiResponse<List<ModuleResponse>>> {

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        val resultModules = MutableLiveData<ApiResponse<List<ModuleResponse>>>()

        handler.postDelayed({
            resultModules.value = ApiResponse.success(jsonHelper.loadModule(courseId))

            if (TESTING_FLAG == TESTING_FLAG_MATCH)
                if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                    EspressoIdlingResource.decrement()

        }, SERVICE_LATENCY_IN_MILLIS)

        return resultModules
    }

    fun getContent(moduleId: String): LiveData<ApiResponse<ContentResponse>> {

        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        val resultContent = MutableLiveData<ApiResponse<ContentResponse>>()

        handler.postDelayed({
            resultContent.value = ApiResponse.success(jsonHelper.loadContent(moduleId))

            if (TESTING_FLAG == TESTING_FLAG_MATCH)
                if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                    EspressoIdlingResource.decrement()

        }, SERVICE_LATENCY_IN_MILLIS)

        return resultContent
    }
}