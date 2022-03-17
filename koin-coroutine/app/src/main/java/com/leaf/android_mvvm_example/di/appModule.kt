/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 5:11
 */

package com.leaf.android_mvvm_example.di

import com.leaf.android_mvvm_example.data.repository.ContributorRepository
import org.koin.dsl.module

val appModule = module {
    factory {
        ContributorRepository(get(), get())
    }
}