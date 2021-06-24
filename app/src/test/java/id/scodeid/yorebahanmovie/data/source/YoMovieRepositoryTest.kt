package id.scodeid.yorebahanmovie.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.scodeid.yorebahanmovie.data.source.remote.RemoteDataSource
import id.scodeid.yorebahanmovie.utils.DataDummy
import id.scodeid.yorebahanmovie.utils.LiveDataTestUtil
import org.junit.Test
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.doAnswer
import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito.*

class YoMovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val remote = mock(RemoteDataSource::class.java)
    private val fakeYoMovieRepository = FakeYoMovieRepository(remote)

    private val responseMovies = DataDummy.generateRemoteDummyMovies()
    private val movieId = responseMovies[0].movieId

    private val responsesTvShow = DataDummy.generateRemoteDummyTvShow()
    private val tvShowId = responsesTvShow[0].tvShowId

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(responseMovies)
            null
        }.`when`(remote).getAllMovies(any())
        val list = LiveDataTestUtil.getValue(fakeYoMovieRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(list)
        assertEquals(responseMovies.size.toLong(), list.size.toLong())
    }

    @Test
    fun getMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(responseMovies)
            null
        }.`when`(remote).getAllMovies(any())

        val list = LiveDataTestUtil.getValue(fakeYoMovieRepository.getMovie(movieId))

        verify(remote).getAllMovies(any())
        assertNotNull(list)
        assertNotNull(list.title)
        assertEquals(responseMovies[0].title, list.title)
    }

    @Test
    fun getAllTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(responsesTvShow)
            null
        }.`when`(remote).getAllTvShow(any())
        val list = LiveDataTestUtil.getValue(fakeYoMovieRepository.getAllTvShow())
        verify(remote).getAllTvShow(any())
        assertNotNull(list)
        assertEquals(responsesTvShow.size.toLong(), list.size.toLong())
    }

    @Test
    fun getTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(responsesTvShow)
            null
        }.`when`(remote).getAllTvShow(any())

        val list = LiveDataTestUtil.getValue(fakeYoMovieRepository.getTvShow(tvShowId))

        verify(remote).getAllTvShow(any())
        assertNotNull(list)
        assertNotNull(list.title)
        assertEquals(responsesTvShow[0].title, list.title)
    }
}