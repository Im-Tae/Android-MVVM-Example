package com.example.android_mvvm_example.ui.view.contributors

import android.os.Bundle
import android.view.View
import com.example.android_mvvm_example.R
import com.example.android_mvvm_example.base.BaseFragment
import com.example.android_mvvm_example.databinding.FragmentContributorsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContributorsFragment : BaseFragment<FragmentContributorsBinding, ContributorsViewModel>(
    R.layout.fragment_contributors
) {

    override val viewModel: ContributorsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {

    }
}