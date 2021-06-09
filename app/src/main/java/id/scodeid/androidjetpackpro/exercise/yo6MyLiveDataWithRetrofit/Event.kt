package id.scodeid.androidjetpackpro.exercise.yo6MyLiveDataWithRetrofit

open class Event<out T>(private val contentSaveData: T) {

    @Suppress("MemberVisibilityCanBePrivate")
    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            contentSaveData
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = contentSaveData
}

/**
 * T adalah tipe generic yang bisa digunakan supaya kelas ini
 * dapat membungkus berbagai macam data
 *
*/