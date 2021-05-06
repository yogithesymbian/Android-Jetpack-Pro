package id.scodeid.androidjetpackpro.ui.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.scodeid.androidjetpackpro.R
import id.scodeid.androidjetpackpro.databinding.FragmentBookmarkBinding
import id.scodeid.androidjetpackpro.entity.CourseEntity

class BookmarkFragment : Fragment(), BookmarkFragmentCallback {

private lateinit var fragmentBookmarkBinding: FragmentBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBookmarkBinding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return fragmentBookmarkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            // load data
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[BookmarkViewModel::class.java]
            val courses = viewModel.getBookmarks()

            val adapter = BookmarkAdapter(this)
            adapter.setCourses(courses)

            with(fragmentBookmarkBinding.rvBookmark){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onShareClick(courseEntity: CourseEntity) {
        if (activity != null){
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang")
                .setText(resources.getString(R.string.share_text, courseEntity.title))
                .startChooser()
        }
    }

}