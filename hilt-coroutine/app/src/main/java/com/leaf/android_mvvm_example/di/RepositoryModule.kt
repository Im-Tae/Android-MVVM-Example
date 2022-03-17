/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 5:11
 */

package com.leaf.android_mvvm_example.di

import com.leaf.android_mvvm_example.data.local.dao.ContributorDao
import com.leaf.android_mvvm_example.data.remote.GitHubApi
import com.leaf.android_mvvm_example.data.repository.ContributorRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideContributorRepository(gitHubApi: GitHubApi, contributorDao: ContributorDao) = ContributorRepository(gitHubApi, contributorDao)
}