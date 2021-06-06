package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data

import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote.RemoteDataSource
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito.*

class AcademyRepositoryTest {

    private val remote = mock(RemoteDataSource::class.java)
    private val fakeAcademyRepository = FakeAcademyRepository(remote)

    private val courseResponses = DataDummy.generateRemoteDummyCourses()
    private val courseId = courseResponses[0].id
    private val moduleResponses = DataDummy.generateRemoteDummyModules(courseId)
    private val moduleId = moduleResponses[0].moduleId
    private val content = DataDummy.generateRemoteDummyContent(moduleId)

    @Test
    fun getAllCourses() {
        `when`(remote.getAllCourses()).thenReturn(courseResponses)
        val courseEntities = fakeAcademyRepository.getAllCourses()
        verify(remote).getAllCourses()
        assertNotNull(courseEntities)
        assertEquals(courseResponses.size.toLong(), courseEntities.size.toLong())
    }

    @Test
    fun getAllModulesByCourse() {
        `when`(remote.getModules(courseId)).thenReturn(moduleResponses)
        val moduleEntities = fakeAcademyRepository.getAllModulesByCourse(courseId)
        verify(remote).getModules(courseId)
        assertNotNull(moduleEntities)
        assertEquals(moduleResponses.size.toLong(), moduleEntities.size.toLong())
    }

    @Test
    fun getBookmarkedCourses() {
        `when`(remote.getAllCourses()).thenReturn(courseResponses)
        val courseEntities = fakeAcademyRepository.getBookmarkedCourses()
        verify(remote).getAllCourses()
        assertNotNull(courseEntities)
        assertEquals(courseResponses.size.toLong(), courseEntities.size.toLong())
    }

    @Test
    fun getContent() {
        `when`(remote.getModules(courseId)).thenReturn(moduleResponses)
        `when`(remote.getContent(moduleId)).thenReturn(content)
        val resultModule = fakeAcademyRepository.getContent(courseId, moduleId)
        verify(remote).getContent(moduleId)
        assertNotNull(resultModule)
        assertEquals(content.content, resultModule.contentEntity?.content)
    }

    @Test
    fun getCourseWithModules() {
        `when`(remote.getAllCourses()).thenReturn(courseResponses)
        val resultCourse = fakeAcademyRepository.getCourseWithModules(courseId)
        verify(remote).getAllCourses()
        assertNotNull(resultCourse)
        assertEquals(courseResponses[0].title, resultCourse.title)
    }
}