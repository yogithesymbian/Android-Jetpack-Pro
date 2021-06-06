package id.scodeid.androidjetpackpro.exercise.yo5MyLiveData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.scodeid.androidjetpackpro.R
import id.scodeid.androidjetpackpro.databinding.ActivityMainMyLiveDataBinding

class MainMyLiveDataActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var activityMainMyLiveDataBinding: ActivityMainMyLiveDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainMyLiveDataBinding = ActivityMainMyLiveDataBinding.inflate(layoutInflater)
        setContentView(activityMainMyLiveDataBinding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        subscribe()
    }

    private fun subscribe() {
        val elapsedTimeObserver = Observer<Long?> {
            val newText = this@MainMyLiveDataActivity.resources.getString(R.string.seconds, it)
            activityMainMyLiveDataBinding.timerTextview.text = newText
        }

        mainViewModel.getElapsedTime().observe(this, elapsedTimeObserver)
    }
}