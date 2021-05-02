package id.scodeid.androidjetpackpro.exercise.yo1unittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import id.scodeid.androidjetpackpro.R
import id.scodeid.androidjetpackpro.databinding.ActivityMainMockitoBinding

class MainMockitoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var activityMainMockitoBinding: ActivityMainMockitoBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainMockitoBinding = ActivityMainMockitoBinding.inflate(layoutInflater)
        setContentView(activityMainMockitoBinding.root)

        mainViewModel = MainViewModel(CuboidModel())

        activityMainMockitoBinding.btnSave.setOnClickListener(this)
        activityMainMockitoBinding.btnCalculateSurfaceArea.setOnClickListener(this)
        activityMainMockitoBinding.btnCalculateCircumference.setOnClickListener(this)
        activityMainMockitoBinding.btnCalculateVolume.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        val length = activityMainMockitoBinding.edtLength.text.toString().trim()
        val width = activityMainMockitoBinding.edtWidth.text.toString().trim()
        val height = activityMainMockitoBinding.edtHeight.text.toString().trim()
        when {
            TextUtils.isEmpty(length) -> {
                activityMainMockitoBinding.edtLength.error = "Field ini tidak boleh kosong"
            }
            TextUtils.isEmpty(width) -> {
                activityMainMockitoBinding.edtWidth.error = "Field ini tidak boleh kosong"
            }
            TextUtils.isEmpty(height) -> {
                activityMainMockitoBinding.edtHeight.error = "Field ini tidak boleh kosong"
            }
            else -> {
                val valueLength = length.toDouble()
                val valueWidth = width.toDouble()
                val valueHeight = height.toDouble()
                when (v.id) {
                    R.id.btn_save -> {
                        mainViewModel.save(valueLength, valueWidth, valueHeight)
                        visible()
                    }
                    R.id.btn_calculate_circumference -> {
                        activityMainMockitoBinding.tvResult.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                    R.id.btn_calculate_surface_area -> {
                        activityMainMockitoBinding.tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    R.id.btn_calculate_volume -> {
                        activityMainMockitoBinding.tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible() {
        activityMainMockitoBinding.btnCalculateVolume.visibility = View.VISIBLE
        activityMainMockitoBinding.btnCalculateCircumference.visibility = View.VISIBLE
        activityMainMockitoBinding.btnCalculateSurfaceArea.visibility = View.VISIBLE
        activityMainMockitoBinding.btnSave.visibility = View.GONE
    }

    private fun gone() {
        activityMainMockitoBinding.btnCalculateVolume.visibility = View.GONE
        activityMainMockitoBinding.btnCalculateCircumference.visibility = View.GONE
        activityMainMockitoBinding.btnCalculateSurfaceArea.visibility = View.GONE
        activityMainMockitoBinding.btnSave.visibility = View.VISIBLE
    }
}