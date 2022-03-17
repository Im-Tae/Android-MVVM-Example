/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 17. 오전 11:39
 */

package com.leaf.android_mvvm_example.di

import com.leaf.android_mvvm_example.ui.view.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val activityModule = module {

    viewModel {
        MainViewModel(get())
    }
}