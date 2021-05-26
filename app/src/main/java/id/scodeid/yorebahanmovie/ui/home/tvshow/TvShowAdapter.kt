package id.scodeid.yorebahanmovie.ui.home.tvshow

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.databinding.ItemsTvShowBinding
import id.scodeid.yorebahanmovie.entity.TvShowEntity
import id.scodeid.yorebahanmovie.ui.home.tvshow.detail.DetailTvShowActivity
import id.scodeid.yorebahanmovie.utils.isEmpty

class TvShowAdapter(private val callback: TvShowFragmentCallback) :
    RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    private val arrListTvShowEntities = ArrayList<TvShowEntity>()

    // init load a manipulation data
    fun setTvShow(listMovieEntities: List<TvShowEntity>?, context: TvShowFragment) {
        if (listMovieEntities == null) return
        this.arrListTvShowEntities.clear()
        this.arrListTvShowEntities.addAll(listMovieEntities)
        if (isEmpty == context.getString(R.string.testEmpty)) {// for testing
            Log.d(TAG_LOG, "is in testing")
            this.arrListTvShowEntities.clear()
        } else
            Log.d(TAG_LOG, "not in testing")
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TvShowAdapter.ViewHolder {
        return ViewHolder(
            ItemsTvShowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TvShowAdapter.ViewHolder, position: Int) =
        holder.bind(arrListTvShowEntities[position])

    override fun getItemCount(): Int {
        arrListTvShowEntities.size.let {
            callback.onCheckDataSize(it)
            return arrListTvShowEntities.size
        }
    }

    inner class ViewHolder(private val binding: ItemsTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShowEntity: TvShowEntity) = with(binding) {
            tvItemTitle.text = tvShowEntity.title
            (tvShowEntity.rating + ' ' + tvShowEntity.date + ' ' + tvShowEntity.genre + ' ' + tvShowEntity.videoTime).also {
                tvGenre.text = it
            }
            Glide.with(itemView.context)
                .load(tvShowEntity.imgPath)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                .error(R.drawable.ic_error)
                .into(imagePoster)
            Glide.with(itemView.context)
                .load(tvShowEntity.imgPath)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                .error(R.drawable.ic_error)
                .into(imgBackdrop)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                intent.putExtra(DetailTvShowActivity.EXTRA_DETAIL_DATA_TV,
                    tvShowEntity.tvShowId)
                itemView.context.startActivity(intent)
            }

            imgShare.setOnClickListener {
                callback.onShareClick(tvShowEntity)
            }

        }
    }

    companion object {
        val TAG_LOG: String = TvShowAdapter::class.java.simpleName
    }

}