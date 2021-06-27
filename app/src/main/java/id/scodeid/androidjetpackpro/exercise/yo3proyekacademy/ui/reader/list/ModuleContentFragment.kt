package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.reader.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import id.scodeid.androidjetpackpro.databinding.FragmentModuleContentBinding
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity.ModuleEntity
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.reader.CourseReaderViewModel
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.viewmodel.ViewModelFactory
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.vo.Status

class ModuleContentFragment : Fragment() {

    private var _fragmentModuleContentBinding: FragmentModuleContentBinding? = null
    private var fragmentModuleContentBinding = _fragmentModuleContentBinding

    private lateinit var viewModel: CourseReaderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentModuleContentBinding =
            FragmentModuleContentBinding.inflate(inflater, container, false)
        return fragmentModuleContentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModelFactory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(
                requireActivity(),
                viewModelFactory
            )[CourseReaderViewModel::class.java]

            fragmentModuleContentBinding?.progressBar?.visibility = View.VISIBLE
            viewModel.selectedModule.observe(viewLifecycleOwner, { moduleEntity ->
                if (moduleEntity != null) {
                    when (moduleEntity.status) {
                        Status.LOADING -> fragmentModuleContentBinding?.progressBar?.visibility =
                            View.VISIBLE
                        Status.SUCCESS -> if (moduleEntity.data != null) {
                            fragmentModuleContentBinding?.progressBar?.visibility = View.GONE
                            if (moduleEntity.data.contentEntity != null) {
                                populateWebView(moduleEntity.data)
                            }
                            setButtonNextPrevState(moduleEntity.data)
                            if (!moduleEntity.data.read) {
                                viewModel.readContent(moduleEntity.data)
                            }
                        }
                        Status.ERROR -> {
                            fragmentModuleContentBinding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                    fragmentModuleContentBinding?.btnNext?.setOnClickListener { viewModel.setNextPage() }
                    fragmentModuleContentBinding?.btnPrev?.setOnClickListener { viewModel.setPrevPage() }
                }
            })
        }
    }

    private fun populateWebView(moduleEntity: ModuleEntity) {
        fragmentModuleContentBinding?.webView?.loadData(
            moduleEntity.contentEntity?.content ?: "",
            "text/html",
            "UTF-8"
        )
    }

    private fun setButtonNextPrevState(module: ModuleEntity) {
        if (activity != null) {
            when (module.position) {
                0 -> {
                    fragmentModuleContentBinding.also {
                        it?.btnPrev?.isEnabled = false
                        it?.btnNext?.isEnabled = true
                    }
                }
                viewModel.getModuleSize() - 1 -> {
                    fragmentModuleContentBinding.also {
                        it?.btnPrev?.isEnabled = true
                        it?.btnNext?.isEnabled = false
                    }
                }
                else -> {
                    fragmentModuleContentBinding.also {
                        it?.btnPrev?.isEnabled = true
                        it?.btnNext?.isEnabled = true
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentModuleContentBinding = null
    }

    companion object {
        val TAG: String = ModuleContentFragment::class.java.simpleName
        fun newInstance(): ModuleContentFragment = ModuleContentFragment()
    }
}