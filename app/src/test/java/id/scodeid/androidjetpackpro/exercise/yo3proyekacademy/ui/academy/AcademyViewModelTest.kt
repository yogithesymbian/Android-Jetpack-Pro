package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.academy

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Memuat Courses:
 * Memastikan data course tidak null.
 * Memastikan jumlah data course sesuai dengan yang diharapkan.
 */
class AcademyViewModelTest {

    private lateinit var viewModel: AcademyViewModel

    @Before
    fun setUp(){
        viewModel = AcademyViewModel()
    }

    @Test
    fun getCourse() {
        val courseEntities = viewModel.getCourse()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}