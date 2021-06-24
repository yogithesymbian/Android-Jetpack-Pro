package id.scodeid.yorebahanmovie.ui.home.tvshow.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.databinding.ActivityDetailTvShowBinding
import id.scodeid.yorebahanmovie.databinding.ContentDetailTvShowBinding
import id.scodeid.yorebahanmovie.data.source.local.entity.TvShowEntity
import id.scodeid.yorebahanmovie.utils.gone
import id.scodeid.yorebahanmovie.utils.visible
import id.scodeid.yorebahanmovie.viewmodel.ViewModelFactory

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

        val viewModelFactory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) { // check intent data
            val tvShowId = extras.getString(EXTRA_DETAIL_DATA_TV)
            if (tvShowId != null) {

                activityDetailTvShowBinding.progressBar.visible()
                viewModel.setSelectedTvShow(tvShowId)
                viewModel.getTvShowById().observe(this, { tvshow ->
                    populateCourse(tvshow)
                    activityDetailTvShowBinding.progressBar.gone()
                })
            }
        }

    }

    private fun populateCourse(tvShowEntity: TvShowEntity) {
        contentDetailTvShowBinding.let {
            it.btnPlayYoRebahan.setOnClickListener {
                Toast.makeText(
                    this,
                    getString(R.string.utils_under_construction),
                    Toast.LENGTH_SHORT
                ).show()
            }

            resources.let { r ->
                it.tvDate.text =
                    r.getString(R.string.release_date, tvShowEntity.date)
                it.tvGenre.text =
                    r.getString(R.string.content_detail_movie_val_genre, tvShowEntity.genre)
                it.tvLang.text =
                    r.getString(R.string.content_detail_movie_val_lang, tvShowEntity.language)
                it.tvRelease.text =
                    r.getString(R.string.content_detail_movie_val_status, tvShowEntity.status)
                it.tvVideoScore.text =
                    r.getString(R.string.detail_movie_activity_video_score, tvShowEntity.videoScore)
                it.tvRating.text =
                    r.getString(R.string.content_detail_movie_val_rating, tvShowEntity.rating)
            }

            it.tvTitle.text = tvShowEntity.title
            it.tvDesc.text = tvShowEntity.description
            it.tvVidTime.text = tvShowEntity.videoTime
            it.tvCreatorVal.text = tvShowEntity.creator
            it.tvTypeVal.text = tvShowEntity.type

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