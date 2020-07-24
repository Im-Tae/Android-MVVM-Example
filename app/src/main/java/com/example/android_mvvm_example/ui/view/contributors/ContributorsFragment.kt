package com.example.android_mvvm_example.ui.view.contributors

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.android_mvvm_example.R
import com.example.android_mvvm_example.base.BaseFragment
import com.example.android_mvvm_example.databinding.FragmentContributorsBinding
import com.example.android_mvvm_example.ui.adapter.ContributorsAdapter
import kotlinx.android.synthetic.main.fragment_contributors.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContributorsFragment : BaseFragment<FragmentContributorsBinding, ContributorsViewModel>(
    R.layout.fragment_contributors
) {

    override val viewModel: ContributorsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        viewModel.contributorList.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter?.notifyDataSetChanged()
            recyclerView.adapter = ContributorsAdapter(it)
        })
    }

    private fun init() {
        viewModel.getContributors()
    }

}