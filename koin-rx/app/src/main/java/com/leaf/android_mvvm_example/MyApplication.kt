/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 5:11
 */

package com.leaf.android_mvvm_example

import android.app.Application
import com.leaf.android_mvvm_example.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MyApplication : Application() {

    companion object {
        const val BASE_URL = "http://api.github.com/"
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                appModule,
                activityModule,
                fragmentModule,
                networkModule,
                apiModule,
                databaseModule
            )
        }

        Timber.plant(Timber.DebugTree())
    }
}