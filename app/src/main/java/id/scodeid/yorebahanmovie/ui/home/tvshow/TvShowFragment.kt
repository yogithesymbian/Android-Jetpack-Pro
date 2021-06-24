package id.scodeid.yorebahanmovie.ui.home.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.databinding.FragmentTvShowBinding
import id.scodeid.yorebahanmovie.data.source.local.entity.TvShowEntity
import id.scodeid.yorebahanmovie.ui.home.tvshow.detail.DetailTvShowActivity
import id.scodeid.yorebahanmovie.utils.*
import id.scodeid.yorebahanmovie.viewmodel.ViewModelFactory

class TvShowFragment : Fragment(), TvShowFragmentCallback {

    // init binding view
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            view.setBackgroundColor(
                ResourcesCompat.getColor(
                    resources,
                    R.color.white500,
                    null
                )
            )

            // init viewModel
            val viewModelFactory = ViewModelFactory.getInstance(requireContext())
            val viewModel = ViewModelProvider(
                this,
                viewModelFactory
            )[TvShowViewModel::class.java]

            // set adapter and load a manipulation data
            val tvShowAdapter = TvShowAdapter(this)
            fragmentTvShowBinding.progressBar.visible()

            viewModel.getTvShow().observe(viewLifecycleOwner, { tvshow ->
                fragmentTvShowBinding.progressBar.gone()
                tvShowAdapter.setTvShow(tvshow, this)
                tvShowAdapter.notifyDataSetChanged()
                if (tvShowAdapter.itemCount == 0) hideRv()
                else showRv()
            })

            // config recyclerView for the data
            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = tvShowAdapter
            }
        }
    }

    private fun showRv() {
        fragmentTvShowBinding.let {
            it.rvTvShow.visible()
            it.emptyContent.root.gone()
        }
    }

    private fun hideRv() {
        fragmentTvShowBinding.let {
            it.rvTvShow.gone()
            it.emptyContent.root.visible()
        }
    }

    /**
     * callback from class @TvShowFragmentCallback.kt
     * definition and trigger from adapter
     * manipulation on @this
     */
    override fun onShareClick(tvShowEntity: TvShowEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle(getString(R.string.share_title_chooser))
                .setText(resources.getString(R.string.share_text,
                    tvShowEntity.title,
                    tvShowEntity.cuanValue))
                .startChooser()
        }
    }

    override fun onCheckDataSize(size: Int?) {
        fragmentTvShowBinding.let {
            if (dataFailOnLoad == getString(R.string.testDataFailOnLoad)) {
                it.rvTvShow.gone()
                it.emptyContent.root.gone()
                it.failedLoadContent.root.visible()
            }
        }
    }

    override fun onClickDetailEvent(id: String) {
        val intent = Intent(requireContext(), DetailTvShowActivity::class.java)
        intent.putExtra(DetailTvShowActivity.EXTRA_DETAIL_DATA_TV,
            id)
        requireActivity().startActivity(intent)
    }

}