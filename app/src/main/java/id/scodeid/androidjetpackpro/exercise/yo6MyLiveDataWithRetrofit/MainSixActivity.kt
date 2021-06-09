package id.scodeid.androidjetpackpro.exercise.yo6MyLiveDataWithRetrofit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import id.scodeid.androidjetpackpro.R
import id.scodeid.androidjetpackpro.databinding.ActivityMainSixBinding

class MainSixActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainSixBinding = ActivityMainSixBinding.inflate(layoutInflater)
        setContentView(activityMainSixBinding.root)

        supportActionBar?.hide()

        mainViewModel.also { mvvm ->
            activityMainSixBinding.also { bind ->
                mvvm.restaurant.observe(this, { restaurant ->
                    bind.tvTitle.text = restaurant.name
                    bind.tvDescription.text = restaurant.description
                    Glide.with(this)
                        .load("https://restaurant-api.dicoding.dev/images/large/${restaurant.pictureId}")
                        .into(bind.ivPicture)
                })

                mvvm.listReview.observe(this, { consumerReviews ->
                    val listReview = consumerReviews.map {
                        "${it.review}\n- ${it.name}"
                    }
                    bind.lvReview.adapter =
                        ArrayAdapter(this, R.layout.item_review, listReview)
                    bind.edReview.setText("")
                })

                 mvvm.isLoading.observe(this, {
                     bind.progressBar.visibility = if (it) View.VISIBLE else View.GONE
                 })

                bind.btnSend.setOnClickListener{
                    mvvm.postReview(bind.edReview.text.toString())
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(it.windowToken, 0)
                }

                mvvm.snackbarText.observe(this, {
                    it.getContentIfNotHandled()?.let { msg ->
                        Snackbar.make(
                            window.decorView.rootView,
                            msg,
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                })

            }
        }
    }
}