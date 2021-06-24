package id.scodeid.yorebahanmovie.ui.home.tvshow.detail

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
class DetailTvShowActivityTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<TvShowEntity>

    @Mock
    private lateinit var yoMovieRepository: YoMovieRepository

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(yoMovieRepository)
        viewModel.setSelectedTvShow(tvShowId) // set courseId
    }

    @Test
    fun getTvShowDetailData() {
        val mutableLiveData = MutableLiveData<TvShowEntity>()
        mutableLiveData.value = dummyTvShow

        `when`(yoMovieRepository.getTvShow(tvShowId))
            .thenReturn(mutableLiveData)

        val tvShowEntity = viewModel.getTvShowById().value as TvShowEntity
        verify(yoMovieRepository).getTvShow(tvShowId)
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

        viewModel.getTvShowById().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}