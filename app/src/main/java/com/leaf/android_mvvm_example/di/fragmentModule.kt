package com.leaf.android_mvvm_example.di

import com.leaf.android_mvvm_example.ui.view.contributors.ContributorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val fragmentModule = module {
    viewModel {
        ContributorViewModel(get())
    }
}