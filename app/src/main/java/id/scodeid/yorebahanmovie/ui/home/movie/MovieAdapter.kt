package id.scodeid.yorebahanmovie.ui.home.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.databinding.ItemsMovieBinding
import id.scodeid.yorebahanmovie.entity.MovieEntity
import id.scodeid.yorebahanmovie.ui.home.movie.detail.DetailMovieActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var arrListMovieEntities = ArrayList<MovieEntity>()

    // init load a manipulation data
    fun setMovies(listMovieEntities: List<MovieEntity>?) {
        if (listMovieEntities == null) return
        this.arrListMovieEntities.clear()
        this.arrListMovieEntities.addAll(listMovieEntities)
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ViewHolder {
        return ViewHolder(ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(arrListMovieEntities[position])

    override fun getItemCount(): Int = arrListMovieEntities.size

    inner class ViewHolder(private val binding: ItemsMovieBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(movieEntity: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movieEntity.title
                tvItemDate.text =
                        itemView.resources.getString(R.string.deadline_date, movieEntity.deadline)

                Glide.with(itemView.context)
                        .load(movieEntity.imagePath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                        .error(R.drawable.ic_error)
                        .into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_DETAIL_DATA, movieEntity.movieId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}