package id.scodeid.yorebahanmovie.ui.home.movie.detail

import id.scodeid.yorebahanmovie.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyCourse = DataDummy.generateDummyMovies()[0]
    private val courseId = dummyCourse.movieId

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(courseId) // set courseId
    }

    @Test
    fun getCourse() {
        viewModel.setSelectedMovie(dummyCourse.movieId)
        val courseEntity = viewModel.getMovieById()
        assertNotNull(courseEntity)
        assertEquals(dummyCourse.movieId, courseEntity.movieId)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.title, courseEntity.title)
    }

}