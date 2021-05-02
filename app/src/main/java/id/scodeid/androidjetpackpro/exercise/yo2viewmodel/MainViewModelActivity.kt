package id.scodeid.androidjetpackpro.exercise.yo2viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.scodeid.androidjetpackpro.databinding.ActivityMainViewModelBinding

class MainViewModelActivity : AppCompatActivity() {

    private lateinit var activityMainViewModelBinding: ActivityMainViewModelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainViewModelBinding = ActivityMainViewModelBinding.inflate(layoutInflater)
        setContentView(activityMainViewModelBinding.root)

    }
}