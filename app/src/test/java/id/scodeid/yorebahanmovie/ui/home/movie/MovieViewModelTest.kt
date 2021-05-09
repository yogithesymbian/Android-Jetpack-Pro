package id.scodeid.yorebahanmovie.ui.home.movie

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp(){
        viewModel = MovieViewModel()
    }

    @Test
    fun getCourse() {
        val courseEntities = viewModel.getMovies()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}