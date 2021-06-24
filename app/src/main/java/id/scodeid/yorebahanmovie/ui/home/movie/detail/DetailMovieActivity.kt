package id.scodeid.yorebahanmovie.ui.home.movie.detail

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.databinding.ActivityDetailMovieBinding
import id.scodeid.yorebahanmovie.databinding.ContentDetailMovieBinding
import id.scodeid.yorebahanmovie.data.source.local.entity.MovieEntity
import id.scodeid.yorebahanmovie.utils.gone
import id.scodeid.yorebahanmovie.utils.invisible
import id.scodeid.yorebahanmovie.utils.showSnackBar
import id.scodeid.yorebahanmovie.utils.visible
import id.scodeid.yorebahanmovie.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL_DATA = "extra_detail_data"
    }

    // init binding view
    private lateinit var contentDetailMovieBinding: ContentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        contentDetailMovieBinding = activityDetailMovieBinding.detailContent
        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activityDetailMovieBinding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val viewModelFactory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) { // check intent data
            val movieId = extras.getString(EXTRA_DETAIL_DATA)
            if (movieId != null) {

                activityDetailMovieBinding.progressBar.visible()
                viewModel.setSelectedMovie(movieId)
                viewModel.getMovieById().observe(this, { movies ->
                    populateCourse(movies)
                    activityDetailMovieBinding.progressBar.gone()
                })
            }
        }

    }

    @SuppressLint("StringFormatInvalid") // percent user score
    private fun populateCourse(movieEntity: MovieEntity) {
        contentDetailMovieBinding.let {
            it.btnPlayYoRebahan.setOnClickListener {
                Toast.makeText(
                    this,
                    getString(R.string.utils_under_construction),
                    Toast.LENGTH_SHORT
                ).show()
            }
            it.cvUserScore.also { cus ->
                cus.setOnClickListener {
                    cus.showSnackBar(
                        getString(
                            R.string.detail_movie_activity_video_score,
                            movieEntity.videoScore
                        ), Snackbar.LENGTH_SHORT
                    )
                }
            }

            when (movieEntity.videoScore.toInt()) {
                in 70..80 -> it.cvUserScore.setCardBackgroundColor(resources.getColor(R.color.gold))
                in 80..100 -> it.cvUserScore.setCardBackgroundColor(resources.getColor(R.color.rebahan_200))
                else -> it.cvUserScore.setCardBackgroundColor(resources.getColor(R.color.black))
            }

            if (movieEntity.adult)
                it.tvAdult.visible()
            else
                it.tvAdult.invisible()

            resources.let { r ->
                it.tvCuanValue.text =
                    r.getString(R.string.item_movie_get_cuan_val, movieEntity.cuanValue)
                it.btnRating.text =
                    r.getString(R.string.content_detail_movie_val_rating, movieEntity.rating)
                it.tvDeadLine.text = r.getString(R.string.release_date, movieEntity.date)

                it.btnRelease.text =
                    r.getString(R.string.content_detail_movie_val_status, movieEntity.status)
                it.tvGenre.text =
                    r.getString(R.string.content_detail_movie_val_genre, movieEntity.genre)
                it.tvDirector.text =
                    r.getString(R.string.content_detail_movie_val_director, movieEntity.director)

                it.tvLang.text =
                    r.getString(R.string.content_detail_movie_val_lang, movieEntity.language)
                it.tvVideoScore.text = r.getString(
                    R.string.content_detail_movie_val_user_score_percent,
                    movieEntity.videoScore
                )
            }
            it.tvTitle.paintFlags = Paint.UNDERLINE_TEXT_FLAG
            it.tvTitle.text = movieEntity.title
            it.tvDesc.text = movieEntity.description

            it.tvVidTime.text = movieEntity.videoTime
            it.tvBudgetValue.text = movieEntity.budget
            it.tvIncomeValue.text = movieEntity.income

            Glide.with(this)
                .asBitmap()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .load(movieEntity.imgPath)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(it.imagePoster)
            Glide.with(this)
                .asBitmap()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .load(movieEntity.imgPath)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(it.imgBackdrop)
        }
    }
}