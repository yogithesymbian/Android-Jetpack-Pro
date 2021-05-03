package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.reader.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.scodeid.androidjetpackpro.R
import id.scodeid.androidjetpackpro.databinding.FragmentModuleContentBinding
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.entity.ContentEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.reader.content.ModuleListFragment

class ModuleContentFragment : Fragment() {


    companion object {
        val TAG: String = ModuleContentFragment::class.java.simpleName
        fun newInstance(): ModuleContentFragment = ModuleContentFragment()
    }

    private lateinit var fragmentModuleContentBinding: FragmentModuleContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentModuleContentBinding = FragmentModuleContentBinding.inflate(inflater, container, false)
        return fragmentModuleContentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val contentEntity = ContentEntity("" +
                    "<h3 class=\\\"fr-text-bordered\\\"> Contoh Content</h3> " +
                    "<p> Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores molestiae quidem tempore voluptates. Commodi libero perferendis qui suscipit? Accusamus aperiam excepturi, facilis iure laboriosam nihil obcaecati qui ratione vitae voluptatibus. </p>")
            populateWebView(contentEntity)
        }
    }

    private fun populateWebView(contentEntity: ContentEntity) {
        fragmentModuleContentBinding.webView.loadData(contentEntity.content ?: "", "text/html", "UTF-8")
    }
}