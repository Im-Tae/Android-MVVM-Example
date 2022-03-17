/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 5:11
 */

package com.leaf.android_mvvm_example.di

import androidx.room.Room
import com.leaf.android_mvvm_example.R
import com.leaf.android_mvvm_example.data.local.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            androidApplication().baseContext.getString(R.string.app_name)
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<AppDatabase>().contributorDAO()
    }

}