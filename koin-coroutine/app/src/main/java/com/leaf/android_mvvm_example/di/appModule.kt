package com.leaf.android_mvvm_example.di

import com.leaf.android_mvvm_example.data.repository.ContributorRepository
import org.koin.dsl.module

val appModule = module {
    factory {
        ContributorRepository(get(), get())
    }
}