package id.scodeid.androidjetpackpro.exercise.yo2viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import id.scodeid.androidjetpackpro.databinding.ActivityMainViewModelBinding

class MainViewModelActivity : AppCompatActivity() {

    private lateinit var activityMainViewModelBinding: ActivityMainViewModelBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainViewModelBinding = ActivityMainViewModelBinding.inflate(layoutInflater)
        setContentView(activityMainViewModelBinding.root)

        displayResult()

        activityMainViewModelBinding.btnCalculate.setOnClickListener{
            val width = activityMainViewModelBinding.edtWidth.text.toString()
            val height = activityMainViewModelBinding.edtHeight.text.toString()
            val length = activityMainViewModelBinding.edtLength.text.toString()

            when{
                width.isEmpty() -> {
                    activityMainViewModelBinding.edtWidth.error = "Masih Kosong"
                }
                height.isEmpty() -> {
                    activityMainViewModelBinding.edtHeight.error = "Masih Kosong"
                }
                length.isEmpty() -> {
                    activityMainViewModelBinding.edtLength.error = "Masih Kosong"
                }
                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }
            }
        }

    }

    private fun displayResult() {
        activityMainViewModelBinding.tvResult.text = viewModel.result.toString()
    }
}