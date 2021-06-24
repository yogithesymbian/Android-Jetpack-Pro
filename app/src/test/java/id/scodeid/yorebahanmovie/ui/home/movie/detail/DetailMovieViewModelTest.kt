package id.scodeid.yorebahanmovie.ui.home.movie.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import id.scodeid.yorebahanmovie.data.source.YoMovieRepository
import id.scodeid.yorebahanmovie.data.source.local.entity.MovieEntity
import id.scodeid.yorebahanmovie.utils.DataDummy
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
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovies.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<MovieEntity>

    @Mock
    private lateinit var yoMovieRepository: YoMovieRepository

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(yoMovieRepository)
        viewModel.setSelectedMovie(movieId) // set courseId
    }

    @Test
    fun getMovieDetailData() {

        val mutableLiveData = MutableLiveData<MovieEntity>()
        mutableLiveData.value = dummyMovies

        `when`(yoMovieRepository.getMovie(movieId))
            .thenReturn(mutableLiveData)

        val movieEntity = viewModel.getMovieById().value as MovieEntity
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

        viewModel.getMovieById().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

}