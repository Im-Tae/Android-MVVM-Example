package com.leaf.android_mvvm_example.di

import com.leaf.android_mvvm_example.data.remote.GitHubApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(GitHubApi::class.java) }
}