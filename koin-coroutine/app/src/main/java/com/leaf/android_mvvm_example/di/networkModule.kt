/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 7:26
 */

package com.leaf.android_mvvm_example.di

import com.leaf.android_mvvm_example.MyApplication
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

private val provideOkHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(MyApplication.BASE_URL)
            .client(provideOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}