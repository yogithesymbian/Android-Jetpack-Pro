package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.academy

import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.AcademyRepository
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.CourseEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AcademyViewModelTest {

    private lateinit var viewModel: AcademyViewModel

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Before
    fun setUp() {
        viewModel = AcademyViewModel(academyRepository)
    }

    @Test
    fun getCourse() {
        `when`(academyRepository.getAllCourses())
            .thenReturn(DataDummy.generateDummyCourses() as ArrayList<CourseEntity>?)

        val courseEntities = viewModel.getCourse()

        verify(academyRepository).getAllCourses()

        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}