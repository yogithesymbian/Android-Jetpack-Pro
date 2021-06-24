package id.scodeid.yorebahanmovie.ui.home


import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.utils.DataDummy
import id.scodeid.yorebahanmovie.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @get:Rule
    val activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idLingResource)
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idLingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
            dummyMovie.size - 1))

    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
            1,
            click()))

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[1].title)))

        onView(withId(R.id.btn_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_rating)).check(matches(withText("Rating : ${dummyMovie[1].rating}")))

        onView(withId(R.id.tv_vid_time)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vid_time)).check(matches(withText(dummyMovie[1].videoTime)))

        onView(withId(R.id.btn_release)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_release)).check(matches(withText("Status : ${dummyMovie[1].status}")))

        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText("Genre : ${dummyMovie[1].genre}")))

        onView(withId(R.id.tv_lang)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_lang)).check(matches(withText("Language : ${dummyMovie[1].language}")))

        onView(withId(R.id.tv_dead_line)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_dead_line)).check(matches(withText("Release ${dummyMovie[1].date}")))

        onView(withId(R.id.tv_video_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_video_score)).check(matches(withText("${dummyMovie[1].videoScore}%")))

        onView(isRoot()).perform(swipeUp())

        onView(withId(R.id.tv_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc)).check(matches(withText(dummyMovie[1].description)))

        onView(withId(R.id.tv_budget_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_budget_value)).check(matches(withText(dummyMovie[1].budget)))

        onView(withId(R.id.tv_income_value)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_income_value)).check(matches(withText(dummyMovie[1].income)))
    }

    @Test
    fun loadTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
            dummyTvShow.size - 1))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))

        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
            0,
            click()))

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].title)))

        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(withText("Release ${dummyTvShow[0].date}")))

        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText("Genre : ${dummyTvShow[0].genre}")))

        onView(withId(R.id.tv_lang)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_lang)).check(matches(withText("Language : ${dummyTvShow[0].language}")))

        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(withText("Status : ${dummyTvShow[0].status}")))

        onView(withId(R.id.tv_video_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_video_score)).check(matches(withText("Video Score : ${dummyTvShow[0].videoScore}%")))

        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText("Rating : ${dummyTvShow[0].rating}")))

        onView(withId(R.id.tv_vid_time)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vid_time)).check(matches(withText(dummyTvShow[0].videoTime)))


        onView(withId(R.id.tv_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc)).check(matches(withText(dummyTvShow[0].description)))

        onView(isRoot()).perform(swipeUp())

        onView(withId(R.id.tv_creator_val)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_creator_val)).check(matches(withText(dummyTvShow[0].creator)))


        onView(withId(R.id.tv_type_val)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_type_val)).check(matches(withText(dummyTvShow[0].type)))
    }
}