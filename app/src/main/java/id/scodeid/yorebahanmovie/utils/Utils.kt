package id.scodeid.yorebahanmovie.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.showSnackBar(msg: String, length: Int) {
    showSnackBar(msg, length, null) {}
}

fun View.showSnackBar(
    msg: String,
    length: Int,
    actionMessage: CharSequence?,
    action: (View) -> Unit,
) {
    Snackbar.make(this, msg, length).setAction(actionMessage) {
        action(this)
    }.show()
}

/**
 * VARIABLE TESTING
 */
const val TESTING_FLAG = "isTest"
//const val TESTING_FLAG_MATCH = "isTest"
const val TESTING_FLAG_MATCH = "isNotTest"

//const val isEmpty = "testEmpty"
const val isEmpty = "testNotEmpty"
//const val dataFailOnLoad = "testDataFailOnLoad"
const val dataFailOnLoad = "testDataNotFailOnLoad"