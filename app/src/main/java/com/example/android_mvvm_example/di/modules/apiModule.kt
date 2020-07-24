package com.example.android_mvvm_example.di.modules

import com.example.android_mvvm_example.retrofit.network.GitHubApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(GitHubApi::class.java) }
}