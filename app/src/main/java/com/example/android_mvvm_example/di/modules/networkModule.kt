package com.example.android_mvvm_example.di.modules

import com.example.android_mvvm_example.di.app.MyApplication
import com.example.android_mvvm_example.retrofit.network.GitHubApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

private val provideOkHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(MyApplication.BASE_URL)
            .client(provideOkHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}