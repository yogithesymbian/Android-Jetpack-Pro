package id.scodeid.yorebahanmovie.ui.home.tvshow

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShowData() {
        val movieEntities = viewModel.getTvShow()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }
}