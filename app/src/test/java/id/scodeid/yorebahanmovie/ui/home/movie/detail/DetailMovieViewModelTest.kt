package id.scodeid.yorebahanmovie.ui.home.movie.detail

import id.scodeid.yorebahanmovie.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovies.movieId

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId) // set courseId
    }

    @Test
    fun getMovieDetailData() {
        viewModel.setSelectedMovie(dummyMovies.movieId)
        val movieEntity = viewModel.getMovieById()
        assertNotNull(movieEntity)
        assertEquals(dummyMovies.movieId, movieEntity.movieId)
        assertEquals(dummyMovies.date, movieEntity.date)
        assertEquals(dummyMovies.description, movieEntity.description)
        assertEquals(dummyMovies.imgPath, movieEntity.imgPath)
        assertEquals(dummyMovies.title, movieEntity.title)
    }

}