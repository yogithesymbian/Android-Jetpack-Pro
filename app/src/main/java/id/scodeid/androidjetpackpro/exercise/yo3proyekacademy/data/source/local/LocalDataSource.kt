package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local

import androidx.lifecycle.LiveData
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity.*
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.room.AcademyDao

class LocalDataSource private constructor(private val academyDao: AcademyDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(academyDao: AcademyDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(academyDao)
    }

    fun getAllCourses(): LiveData<List<CourseEntity>> = academyDao.getCourses()

    fun getBookmarkedCourses(): LiveData<List<CourseEntity>> = academyDao.getBookmarkedCourse()

    fun getCourseWithModules(courseId: String): LiveData<CourseWithModule> =
        academyDao.getCourseWithModuleById(courseId)

    fun getAllModulesByCourse(courseId: String): LiveData<List<ModuleEntity>> =
        academyDao.getModulesByCourseId(courseId)

    fun insertCourses(courses: List<CourseEntity>) = academyDao.insertCourses(courses)

    fun insertModules(modules: List<ModuleEntity>) = academyDao.insertModules(modules)

    fun setCourseBookmark(course: CourseEntity, newState: Boolean) {
        course.bookmarked = newState
        academyDao.updateCourse(course)
    }

    fun getModuleWithContent(moduleId: String): LiveData<ModuleEntity> =
        academyDao.getModuleById(moduleId)

    fun updateContent(content: String, moduleId: String) {
        academyDao.updateModuleByContent(content, moduleId)
    }

    fun setReadModule(module: ModuleEntity) {
        module.read = true
        academyDao.updateModule(module)
    }
}