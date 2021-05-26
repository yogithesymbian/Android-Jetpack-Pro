package id.scodeid.yorebahanmovie.ui.home.tvshow.detail

import id.scodeid.yorebahanmovie.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailTvShowActivityTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        viewModel.setSelectedTvShow(tvShowId) // set courseId
    }

    @Test
    fun getTvShowDetailData() {
        viewModel.setSelectedTvShow(dummyTvShow.tvShowId)
        val tvShowEntity = viewModel.getTvShowById()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.tvShowId, tvShowEntity.tvShowId)
        assertEquals(dummyTvShow.bookmarked, tvShowEntity.bookmarked)
        assertEquals(dummyTvShow.imgPath, tvShowEntity.imgPath)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.rating, tvShowEntity.rating)
        assertEquals(dummyTvShow.date, tvShowEntity.date)
        assertEquals(dummyTvShow.genre, tvShowEntity.genre)
        assertEquals(dummyTvShow.videoTime, tvShowEntity.videoTime)
        assertEquals(dummyTvShow.description, tvShowEntity.description)
        assertEquals(dummyTvShow.cuanValue, tvShowEntity.cuanValue)
        assertEquals(dummyTvShow.videoScore, tvShowEntity.videoScore)
        assertEquals(dummyTvShow.status, tvShowEntity.status)
        assertEquals(dummyTvShow.creator, tvShowEntity.creator)
        assertEquals(dummyTvShow.language, tvShowEntity.language)
        assertEquals(dummyTvShow.type, tvShowEntity.type)
        assertEquals(dummyTvShow.adult, tvShowEntity.adult)
    }
}