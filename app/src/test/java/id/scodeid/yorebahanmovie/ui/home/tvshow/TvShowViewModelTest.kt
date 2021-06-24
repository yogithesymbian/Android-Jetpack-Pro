package id.scodeid.yorebahanmovie.ui.home.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import id.scodeid.yorebahanmovie.data.source.YoMovieRepository
import id.scodeid.yorebahanmovie.data.source.local.entity.TvShowEntity
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<List<TvShowEntity>>

    @Mock
    private lateinit var yoMovieRepository: YoMovieRepository

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(yoMovieRepository)
    }

    @Test
    fun getTvShowData() {
        val dummyTvShow = DataDummy.generateDummyTvShow()
        val mutableLiveData = MutableLiveData<List<TvShowEntity>>()
        mutableLiveData.value = dummyTvShow

        `when`(yoMovieRepository.getAllTvShow())
            .thenReturn(mutableLiveData)
        val list = viewModel.getTvShow().value
        verify(yoMovieRepository).getAllTvShow()
        assertNotNull(list)
        assertEquals(10, list?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}