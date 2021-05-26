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
        assertEquals(dummyMovies.bookmarked, movieEntity.bookmarked)
        assertEquals(dummyMovies.imgPath, movieEntity.imgPath)
        assertEquals(dummyMovies.title, movieEntity.title)
        assertEquals(dummyMovies.rating, movieEntity.rating)
        assertEquals(dummyMovies.date, movieEntity.date)
        assertEquals(dummyMovies.genre, movieEntity.genre)
        assertEquals(dummyMovies.videoTime, movieEntity.videoTime)
        assertEquals(dummyMovies.description, movieEntity.description)
        assertEquals(dummyMovies.cuanValue, movieEntity.cuanValue)
        assertEquals(dummyMovies.videoScore, movieEntity.videoScore)
        assertEquals(dummyMovies.status, movieEntity.status)
        assertEquals(dummyMovies.director, movieEntity.director)
        assertEquals(dummyMovies.language, movieEntity.language)
        assertEquals(dummyMovies.income, movieEntity.income)
        assertEquals(dummyMovies.adult, movieEntity.adult)
    }

}