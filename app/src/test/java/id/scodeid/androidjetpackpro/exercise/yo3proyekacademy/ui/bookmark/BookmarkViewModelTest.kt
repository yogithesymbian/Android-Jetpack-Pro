package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.bookmark

import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.AcademyRepository
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.CourseEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @Mock
    private lateinit var academyRepository: AcademyRepository


    @Before
    fun setUp() {
        viewModel = BookmarkViewModel(academyRepository)
    }

    @Test
    fun getBookmarks() {
        `when`(academyRepository.getBookmarkedCourses()).thenReturn(
            DataDummy.generateDummyCourses() as ArrayList<CourseEntity>?
        )
        val courseEntities = viewModel.getBookmarks()
        verify(academyRepository).getBookmarkedCourses()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }

}