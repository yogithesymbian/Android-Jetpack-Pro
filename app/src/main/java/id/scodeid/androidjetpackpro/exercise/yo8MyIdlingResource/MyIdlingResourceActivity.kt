package id.scodeid.androidjetpackpro.exercise.yo8MyIdlingResource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import id.scodeid.androidjetpackpro.R
import id.scodeid.androidjetpackpro.databinding.ActivityMyIdlingResourceBinding
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.EspressoIdlingResource
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.TESTING_FLAG
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.TESTING_FLAG_MATCH
import kotlinx.coroutines.delay

class MyIdlingResourceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyIdlingResourceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_idling_resource)

        binding = ActivityMyIdlingResourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            delay1()
            delay2()
        }

    }

    private fun delay2() {
        if (TESTING_FLAG == TESTING_FLAG_MATCH)
            EspressoIdlingResource.increment()

        Handler(Looper.getMainLooper()).postDelayed({
            binding.textView.text = getString(R.string.delay2)
            if (TESTING_FLAG == TESTING_FLAG_MATCH)
                if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                    EspressoIdlingResource.decrement()
        }, 3000)
    }

    private fun delay1() {
        EspressoIdlingResource.increment()

        Handler(Looper.getMainLooper()).postDelayed({
            binding.textView.text = getString(R.string.delay1)

            if (TESTING_FLAG == TESTING_FLAG_MATCH)
                if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow)
                    EspressoIdlingResource.decrement() // Memberitahukan bahwa tugas sudah selesai dijalankan
        }, 2000)
    }
}