package com.leaf.android_mvvm_example.ui.view.contributors

import androidx.core.view.isVisible
import com.leaf.android_mvvm_example.R
import com.leaf.android_mvvm_example.base.BaseFragment
import com.leaf.android_mvvm_example.databinding.FragmentContributorsBinding
import com.leaf.android_mvvm_example.ui.adapter.ContributorAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContributorsFragment : BaseFragment<FragmentContributorsBinding, ContributorsViewModel>(
    R.layout.fragment_contributors
) {

    override val viewModel: ContributorsViewModel by viewModel()

    override fun initLiveData() {

        viewModel.contributorList.observe(viewLifecycleOwner) {
            binding.recyclerView.apply {
                adapter = ContributorAdapter()
                (adapter as ContributorAdapter).submitList(it)
                scheduleLayoutAnimation()
            }
        }

        viewModel.showProgress.observe(viewLifecycleOwner) {

            binding.progress.isVisible = it
        }
    }

    override fun initListener() {

        binding.apply {

            button.setOnClickListener {

                val owner = ownerEditText.text.toString()
                val repo = repoEditText.text.toString()

                viewModel.getContributors(owner, repo)
            }
        }
    }
}