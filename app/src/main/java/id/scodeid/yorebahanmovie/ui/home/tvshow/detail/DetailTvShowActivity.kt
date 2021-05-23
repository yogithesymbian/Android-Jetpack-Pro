package id.scodeid.yorebahanmovie.ui.home.tvshow.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.databinding.ActivityDetailTvShowBinding
import id.scodeid.yorebahanmovie.databinding.ContentDetailTvShowBinding
import id.scodeid.yorebahanmovie.entity.TvShowEntity

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL_DATA_TV = "extra_detail_data_tv"
    }

    // init binding view
    private lateinit var contentDetailTvShowBinding: ContentDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        contentDetailTvShowBinding = activityDetailTvShowBinding.detailContent
        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activityDetailTvShowBinding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) { // check intent data
            val tvShowId = extras.getString(EXTRA_DETAIL_DATA_TV)
            if (tvShowId != null) {
                viewModel.setSelectedTvShow(tvShowId)
                populateCourse(viewModel.getTvShowById())
            }
        }

    }

    private fun populateCourse(tvShowEntity: TvShowEntity) {
        contentDetailTvShowBinding.let {
            resources.let { r ->
                it.textDate.text =
                    r.getString(R.string.deadline_date, tvShowEntity.date)
            }
            it.tvTitle.text = tvShowEntity.title
            it.tvDesc.text = tvShowEntity.description

            Glide.with(this)
                .load(tvShowEntity.imgPath)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(it.imagePoster)
        }
    }
}