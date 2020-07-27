package com.example.android_mvvm_example.di.modules

import com.example.android_mvvm_example.model.repository.ContributorRepository
import org.koin.dsl.module

val appModule = module {
    factory {
        ContributorRepository()
    }
}