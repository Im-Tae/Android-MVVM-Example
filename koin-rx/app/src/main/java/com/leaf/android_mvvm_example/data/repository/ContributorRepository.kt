/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 7:42
 */

package com.leaf.android_mvvm_example.data.repository

import com.leaf.android_mvvm_example.data.domain.Contributor
import com.leaf.android_mvvm_example.data.local.dao.ContributorDao
import com.leaf.android_mvvm_example.data.remote.GitHubApi
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.component.KoinComponent

class ContributorRepository(
    private val gitHubApi: GitHubApi,
    private val contributorDao: ContributorDao
) : KoinComponent {

    fun getContributors(owner: String, repo: String): Single<List<Contributor>> {

        return gitHubApi.getObContributors(owner, repo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {

                contributorDao.deleteAll()
                    .subscribeOn(Schedulers.io())
                    .subscribe()

                contributorDao
                    .insertContributors(*it.toTypedArray())
                    .subscribeOn(Schedulers.io())
                    .subscribe()
            }
    }

    fun getContributors(): Flowable<List<Contributor>> =
        contributorDao.getContributors()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}