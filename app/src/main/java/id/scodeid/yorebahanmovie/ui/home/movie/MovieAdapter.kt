package id.scodeid.yorebahanmovie.ui.home.movie

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.data.source.local.entity.MovieEntity
import id.scodeid.yorebahanmovie.databinding.ItemsMovieBinding
import id.scodeid.yorebahanmovie.utils.isEmpty

class MovieAdapter(private val callback: MovieFragmentCallback) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var arrListMovieEntities = ArrayList<MovieEntity>()

    // init load a manipulation data
    fun setMovies(listMovieEntities: List<MovieEntity>?, context: MovieFragment) {
        if (listMovieEntities == null) return
        this.arrListMovieEntities.clear()
        this.arrListMovieEntities.addAll(listMovieEntities)
        if (isEmpty == context.getString(R.string.testEmpty)) { // for testing
            Log.d(TAG_LOG, "is in testing")
            this.arrListMovieEntities.clear()
        } else
            Log.d(TAG_LOG, "not in testing")
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        return ViewHolder(
            ItemsMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(arrListMovieEntities[position])

    override fun getItemCount(): Int = arrListMovieEntities.size

    inner class ViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("StringFormatInvalid")
        fun bind(movieEntity: MovieEntity) = with(binding) {

            tvItemTitle.text = movieEntity.title
            tvGenre.text = movieEntity.genre
            tvItemDesc.text = movieEntity.description
            tvItemCuan.text = itemView.resources.getString(R.string.item_movie_get_cuan)
            tvItemCuanGold.text = movieEntity.cuanValue
            tvVideoScore.text = itemView.resources.getString(
                R.string.content_detail_movie_val_user_score_percent,
                movieEntity.videoScore
            )
            tvVideoTime.text = movieEntity.videoTime

            Glide.with(itemView.context)
                .load(movieEntity.imgPath)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                .error(R.drawable.ic_error)
                .into(imgPoster)

            itemView.setOnClickListener {
                callback.onClickDetailEvent(movieEntity.movieId)
            }
            imgShare.setOnClickListener {
                callback.onShareClick(movieEntity)
            }
            cvUserScore.setOnClickListener {
                callback.onVidScoreClick(movieEntity, it)
            }

        }
    }

    companion object {
        val TAG_LOG: String = MovieAdapter::class.java.simpleName
    }

}