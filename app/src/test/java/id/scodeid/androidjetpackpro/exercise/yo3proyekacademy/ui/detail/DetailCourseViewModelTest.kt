package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.AcademyRepository
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity.CourseEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity.CourseWithModule
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity.ModuleEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.DataDummy
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.vo.Resource
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailCourseViewModelTest {

    private lateinit var viewModel: DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var observer: Observer<Resource<CourseWithModule>>


    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Before
    fun setUp() {
        viewModel = DetailCourseViewModel(academyRepository)
        viewModel.setSelectedCourse(courseId) // set courseId
    }

    @Test
    fun getCourseWithModule() {
        val dummyCourseWithModule =
            Resource.success(DataDummy.generateDummyCourseWithModules(dummyCourse, true))
        val course = MutableLiveData<Resource<CourseWithModule>>()
        course.value = dummyCourseWithModule
        `when`(academyRepository.getCourseWithModules(courseId)).thenReturn(course)
        viewModel.courseModule.observeForever(observer)
        verify(observer).onChanged(dummyCourseWithModule)
    }
}