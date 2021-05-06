package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.detail

import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Memuat Course:
 * Memastikan data course tidak null.
 * Memastikan data course sesuai dengan yang diharapkan.
 *
 * Memuat Modules:
 * Memastikan data module tidak null.
 * Memastikan jumlah data module sesuai dengan yang diharapkan.
 */
class DetailCourseViewModelTest {

    private lateinit var viewModel: DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId

    @Before
    fun setUp() {
        viewModel = DetailCourseViewModel()
        viewModel.setSelectedCourse(courseId) // set courseId
    }

    @Test
    fun getCourse() {
        viewModel.setSelectedCourse(dummyCourse.courseId)
        val courseEntity = viewModel.getCourse()
        assertNotNull(courseEntity)
        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.title, courseEntity.title)
    }

    @Test
    fun getModules() {
        val moduleEntities = viewModel.getModules()
        assertNotNull(moduleEntities)
        assertEquals(7, moduleEntities.size.toLong())
    }
}