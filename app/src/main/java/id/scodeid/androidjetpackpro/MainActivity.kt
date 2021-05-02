package id.scodeid.androidjetpackpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.scodeid.androidjetpackpro.databinding.ActivityMainBinding
import id.scodeid.androidjetpackpro.exercise.yo1unittesting.MainMockitoActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnUnitTestingMockito.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_unit_testing_mockito -> {
                startActivity(Intent(this, MainMockitoActivity::class.java))
            }
        }
    }
}