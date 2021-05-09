package id.scodeid.yorebahanmovie.ui.home.tvshow

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
import id.scodeid.yorebahanmovie.entity.TvShowEntity

class TvShowFragment() : Fragment(), TvShowFragmentCallback {

    // init binding view
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
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
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[TvShowViewModel::class.java]

            // set adapter and load a manipulation data
            val adapter = TvShowAdapter(this)
            adapter.setTvShow(viewModel.getTvShow())

            // config recyclerView for the data
            with(fragmentTvShowBinding.rvBookmark) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
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
                .setChooserTitle("Bagikan aplikasi ini sekarang")
                .setText(resources.getString(R.string.share_text, tvShowEntity.title))
                .startChooser()
        }
    }

}