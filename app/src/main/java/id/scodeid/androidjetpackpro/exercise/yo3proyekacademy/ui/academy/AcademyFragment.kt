package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.academy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.scodeid.androidjetpackpro.R
import id.scodeid.androidjetpackpro.databinding.FragmentAcademyBinding
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.DataDummy
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.viewmodel.ViewModelFactory
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.vo.Status

class AcademyFragment : Fragment() {

    // init for binding
    private var _fragmentAcademyBinding: FragmentAcademyBinding? = null
    private val fragmentAcademyBinding get() = _fragmentAcademyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentAcademyBinding = FragmentAcademyBinding.inflate(layoutInflater, container, false)
        return fragmentAcademyBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            // load data
            val viewModelFactory = ViewModelFactory.getInstance(requireContext())
            val viewModel = ViewModelProvider(this, viewModelFactory)[AcademyViewModel::class.java]

            // adapter set
            val academyAdapter = AcademyAdapter()

            viewModel.getCourses().observe(viewLifecycleOwner, { courses ->
                if (courses != null) {
                    when (courses.status) {
                        Status.LOADING -> fragmentAcademyBinding?.progressBar?.visibility =
                            View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentAcademyBinding?.progressBar?.visibility = View.GONE
                            academyAdapter.submitList(courses.data)
                        }
                        Status.ERROR -> {
                            fragmentAcademyBinding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            // recyclerView
            with(fragmentAcademyBinding?.rvAcademy) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = academyAdapter
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentAcademyBinding = null
    }

}