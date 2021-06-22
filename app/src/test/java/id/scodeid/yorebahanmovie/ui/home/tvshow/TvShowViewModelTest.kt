package id.scodeid.yorebahanmovie.ui.home.tvshow

import id.scodeid.yorebahanmovie.data.source.YoMovieRepository
import id.scodeid.yorebahanmovie.data.source.local.entity.TvShowEntity
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Mock
    private lateinit var yoMovieRepository: YoMovieRepository

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(yoMovieRepository)
    }

    @Test
    fun getTvShowData() {
        `when`(yoMovieRepository.getAllTvShow())
            .thenReturn(DataDummy.generateDummyTvShow() as ArrayList<TvShowEntity>)
        val list = viewModel.getTvShow()
        verify(yoMovieRepository).getAllTvShow()
        assertNotNull(list)
        assertEquals(10, list.size)
    }
}