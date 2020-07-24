package com.example.android_mvvm_example.di.app

import android.app.Application
import com.example.android_mvvm_example.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    companion object {
        const val BASE_URL = "https://api.github.com/"
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
                apiModule
            )
        }
    }
}