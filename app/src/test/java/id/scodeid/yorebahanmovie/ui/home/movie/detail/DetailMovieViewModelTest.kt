package id.scodeid.yorebahanmovie.ui.home.movie.detail

import id.scodeid.yorebahanmovie.data.source.YoMovieRepository
import id.scodeid.yorebahanmovie.utils.DataDummy
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovies.movieId

    @Mock
    private lateinit var yoMovieRepository: YoMovieRepository

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(yoMovieRepository)
        viewModel.setSelectedMovie(movieId) // set courseId
    }

    @Test
    fun getMovieDetailData() {
        `when`(yoMovieRepository.getMovie(movieId)).thenReturn(dummyMovies)
        val movieEntity = viewModel.getMovieById()
        verify(yoMovieRepository).getMovie(movieId)
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