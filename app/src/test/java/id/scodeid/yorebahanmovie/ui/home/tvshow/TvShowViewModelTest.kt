import id.scodeid.yorebahanmovie.ui.home.tvshow.TvShowViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp(){
        viewModel = TvShowViewModel()
    }

    @Test
    fun getCourse() {
        val courseEntities = viewModel.getTvShow()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}