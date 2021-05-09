package id.scodeid.yorebahanmovie.ui.home.movie.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.databinding.ActivityDetailMovieBinding
import id.scodeid.yorebahanmovie.databinding.ContentDetailMovieBinding
import id.scodeid.yorebahanmovie.entity.MovieEntity

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

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) { // check intent data
            val movieId = extras.getString(EXTRA_DETAIL_DATA)
            if (movieId != null) {

                viewModel.setSelectedMovie(movieId)
                populateCourse(viewModel.getMovieById())
            }
        }

    }

    private fun populateCourse(movieEntity: MovieEntity) {
        contentDetailMovieBinding.textTitle.text = movieEntity.title
        contentDetailMovieBinding.textDescription.text = movieEntity.description
        contentDetailMovieBinding.textDate.text = resources.getString(R.string.deadline_date, movieEntity.deadline)

        Glide.with(this)
                .load(movieEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                .into(contentDetailMovieBinding.imagePoster)
    }
}