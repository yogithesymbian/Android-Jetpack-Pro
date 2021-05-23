package id.scodeid.yorebahanmovie.ui.home.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.databinding.ItemsTvShowBinding
import id.scodeid.yorebahanmovie.entity.TvShowEntity
import id.scodeid.yorebahanmovie.ui.home.tvshow.detail.DetailTvShowActivity

class TvShowAdapter(private val callback: TvShowFragmentCallback) :
    RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    private val arrListTvShowEntities = ArrayList<TvShowEntity>()

    // init load a manipulation data
    fun setTvShow(listMovieEntities: List<TvShowEntity>?) {
        if (listMovieEntities == null) return
        this.arrListTvShowEntities.clear()
        this.arrListTvShowEntities.addAll(listMovieEntities)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
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

    override fun getItemCount(): Int = arrListTvShowEntities.size

    inner class ViewHolder(private val binding: ItemsTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShowEntity: TvShowEntity) {
            with(binding) {

                Glide.with(itemView.context)
                        .load(tvShowEntity.imgPath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                        .error(R.drawable.ic_error)
                        .into(imgPoster)
                tvItemTitle.text = tvShowEntity.title
                (tvShowEntity.videoPlus + ' ' + tvShowEntity.date + ' ' + tvShowEntity.genre + ' ' + tvShowEntity.videoTime).also {
                    tvGenre.text = it
                }

                tvItemDesc.text = tvShowEntity.description
                tvItemCuan.text = itemView.resources.getString(R.string.item_movie_get_cuan)
                tvItemCuanGold.text = tvShowEntity.cuanValue

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_DETAIL_DATA_TV, tvShowEntity.tvShowId)
                    itemView.context.startActivity(intent)
                }

                imgShare.setOnClickListener {
                    callback.onShareClick(tvShowEntity)
                }

            }
        }
    }

}