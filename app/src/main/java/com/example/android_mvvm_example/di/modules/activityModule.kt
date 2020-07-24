package com.example.android_mvvm_example.di.modules

import com.example.android_mvvm_example.ui.view.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val activityModule = module {
    viewModel {
        MainViewModel()
    }
}