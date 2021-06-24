package id.scodeid.yorebahanmovie.ui.home.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import id.scodeid.yorebahanmovie.data.source.YoMovieRepository
import id.scodeid.yorebahanmovie.data.source.local.entity.MovieEntity
import id.scodeid.yorebahanmovie.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Mock
    private lateinit var yoMovieRepository: YoMovieRepository

    @Before
    fun setUp() {
        viewModel = MovieViewModel(yoMovieRepository)
    }

    @Test
    fun getMovieData() {
        val dummyMovies = DataDummy.generateDummyMovies()
        val mutableLiveData = MutableLiveData<List<MovieEntity>>()
        mutableLiveData.value = dummyMovies

        `when`(yoMovieRepository.getAllMovies())
            .thenReturn(mutableLiveData)
        val list = viewModel.getMovies().value
        verify(yoMovieRepository).getAllMovies()
        assertNotNull(list)
        assertEquals(10, list?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}