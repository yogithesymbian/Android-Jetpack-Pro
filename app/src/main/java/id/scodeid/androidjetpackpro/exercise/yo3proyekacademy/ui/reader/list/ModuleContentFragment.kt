package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.reader.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import id.scodeid.androidjetpackpro.databinding.FragmentModuleContentBinding
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.ModuleEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.reader.CourseReaderViewModel
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.viewmodel.ViewModelFactory

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
        if (activity != null) {
            val viewModelFactory = ViewModelFactory.getInstance(requireContext())
            val viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[CourseReaderViewModel::class.java]
            val module = viewModel.getSelectedModule()
            populateWebView(module)
        }
    }

    private fun populateWebView(moduleEntity: ModuleEntity) {
        fragmentModuleContentBinding.webView.loadData(moduleEntity.contentEntity?.content ?: "", "text/html", "UTF-8")
    }
}