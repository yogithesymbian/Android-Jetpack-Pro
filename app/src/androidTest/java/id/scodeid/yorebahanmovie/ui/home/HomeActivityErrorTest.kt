package id.scodeid.yorebahanmovie.ui.home


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.isGone
import id.scodeid.yorebahanmovie.isVisible
import id.scodeid.yorebahanmovie.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class HomeActivityErrorTest {

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
    fun loadMoviesHasEmpty() {
        onView(withId(R.id.rv_movie)).isGone()
        onView(withId(R.id.empty_content)).isVisible()
        onView(withId(R.id.failed_load_content)).isGone()
    }

    @Test
    fun loadTvShowHasEmpty() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_show)).isGone()
        onView(withId(R.id.empty_content)).isVisible()
        onView(withId(R.id.failed_load_content)).isGone()
    }

    @Test
    fun loadMoviesHasFail() {
        onView(withId(R.id.rv_movie)).isGone()
        onView(withId(R.id.empty_content)).isGone()
        onView(withId(R.id.failed_load_content)).isVisible()
    }

    @Test
    fun loadTvShowHasFail() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_show)).isGone()
        onView(withId(R.id.empty_content)).isGone()
        onView(withId(R.id.failed_load_content)).isVisible()
    }

}