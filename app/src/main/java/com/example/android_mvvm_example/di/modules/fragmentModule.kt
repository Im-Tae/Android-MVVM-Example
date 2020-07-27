package com.example.android_mvvm_example.di.modules

import com.example.android_mvvm_example.ui.view.contributors.ContributorsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val fragmentModule = module {
    viewModel {
        ContributorsViewModel(get())
    }
}