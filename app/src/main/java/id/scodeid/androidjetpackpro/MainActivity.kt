package id.scodeid.androidjetpackpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.scodeid.androidjetpackpro.databinding.ActivityMainBinding
import id.scodeid.androidjetpackpro.exercise.yo1unittesting.MainMockitoActivity
import id.scodeid.androidjetpackpro.exercise.yo2viewmodel.MainViewModelActivity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.home.HomeActivity
import id.scodeid.androidjetpackpro.exercise.yo5MyLiveData.MainMyLiveDataActivity
import id.scodeid.androidjetpackpro.exercise.yo6MyLiveDataWithRetrofit.MainSixActivity
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.ui.main.MainNoteActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
//    /Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnUnitTestingMockito.setOnClickListener(this)
        activityMainBinding.also {
            it.btnInstrumentTest.setOnClickListener {
                startActivity(Intent(this, MainViewModelActivity::class.java))
            }
            it.btnProject.setOnClickListener {
                startActivity(Intent(this, HomeActivity::class.java))
            }
            it.btnLiveData.setOnClickListener {
                startActivity(Intent(this, MainMyLiveDataActivity::class.java))
            }
            it.btnLiveDataWRetro.setOnClickListener {
                startActivity(Intent(this, MainSixActivity::class.java))
            }
            it.btnRoomDb.setOnClickListener {
                startActivity(Intent(this, MainNoteActivity::class.java))
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_unit_testing_mockito -> {
                startActivity(Intent(this, MainMockitoActivity::class.java))
            }
        }
    }
}