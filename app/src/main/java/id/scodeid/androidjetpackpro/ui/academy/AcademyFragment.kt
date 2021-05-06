package id.scodeid.androidjetpackpro.ui.academy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.scodeid.androidjetpackpro.databinding.FragmentAcademyBinding

class AcademyFragment : Fragment() {

    // init for binding
    private lateinit var fragmentAcademyBinding: FragmentAcademyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentAcademyBinding = FragmentAcademyBinding.inflate(layoutInflater, container, false)
        return fragmentAcademyBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            // load data
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[AcademyViewModel::class.java]
            val courses = viewModel.getCourse()

            // adapter set
            val academyAdapter = AcademyAdapter()
            academyAdapter.setCourses(courses)

            // recyclerView
            with(fragmentAcademyBinding.rvAcademy) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = academyAdapter
            }
        }
    }

}