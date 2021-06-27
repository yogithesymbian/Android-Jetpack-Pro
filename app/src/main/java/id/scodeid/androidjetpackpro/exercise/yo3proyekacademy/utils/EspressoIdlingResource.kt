package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {

    private const val RESOURCE = "GLOBAL"
    private val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        espressoTestIdlingResource.increment()
    }

    fun decrement() {
        espressoTestIdlingResource.decrement()
    }

    fun getEspressoIdlingResourceForMainActivity(): IdlingResource = espressoTestIdlingResource
}

/**
 * VARIABLE TESTING
 */
const val TESTING_FLAG = "isTest"
const val TESTING_FLAG_MATCH = "isTest"
//const val TESTING_FLAG_MATCH = "isNotTest"