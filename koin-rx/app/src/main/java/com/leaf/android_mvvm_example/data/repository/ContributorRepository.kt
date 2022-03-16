package com.leaf.android_mvvm_example.data.repository

import com.leaf.android_mvvm_example.data.domain.Contributor
import com.leaf.android_mvvm_example.data.local.dao.ContributorDao
import com.leaf.android_mvvm_example.data.remote.GitHubApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
                CoroutineScope(Dispatchers.IO).launch {
                    insertContributors(*it.toTypedArray())
                }
            }
    }

    fun getContributors() = contributorDao.getContributors()

    private suspend fun insertContributors(vararg name: Contributor) = contributorDao.insertContributors(*name)
}