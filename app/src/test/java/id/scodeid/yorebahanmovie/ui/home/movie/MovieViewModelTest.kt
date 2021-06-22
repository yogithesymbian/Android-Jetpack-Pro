package id.scodeid.yorebahanmovie.ui.home.movie

import id.scodeid.yorebahanmovie.data.source.YoMovieRepository
import id.scodeid.yorebahanmovie.data.source.local.entity.MovieEntity
import id.scodeid.yorebahanmovie.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var yoMovieRepository: YoMovieRepository

    @Before
    fun setUp() {
        viewModel = MovieViewModel(yoMovieRepository)
    }

    @Test
    fun getMovieData() {
        `when`(yoMovieRepository.getAllMovies())
            .thenReturn(DataDummy.generateDummyMovies() as ArrayList<MovieEntity>)
        val list = viewModel.getMovies()
        verify(yoMovieRepository).getAllMovies()
        assertNotNull(list)
        assertEquals(10, list.size)
    }
}