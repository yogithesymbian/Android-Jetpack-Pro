package id.scodeid.androidjetpackpro.exercise.yo5MyLiveData

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.sql.Time
import java.util.*

class MainViewModel: ViewModel() {

    companion object {
        private const val ONE_SECOND = 1000
    }

    private val initialTime = SystemClock.elapsedRealtime()
    private val elapsedTime = MutableLiveData<Long?>() // object live data will subscribe on mainactivity

    init {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask(){
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - initialTime) / 100
                elapsedTime.postValue(newValue)
            }
        }, ONE_SECOND.toLong(), ONE_SECOND.toLong() )
    }

    fun getElapsedTime(): LiveData<Long?> {
        return elapsedTime
    }
}