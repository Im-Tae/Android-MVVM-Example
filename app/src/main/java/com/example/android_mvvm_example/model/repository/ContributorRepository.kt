package com.example.android_mvvm_example.model.repository

import com.example.android_mvvm_example.model.domain.Contributor
import com.example.android_mvvm_example.model.network.GitHubApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class ContributorRepository : KoinComponent {

    private val gitHubApi: GitHubApi by inject()

    fun getContributors(owner: String, repo: String): Single<List<Contributor>> {

        return gitHubApi.getObContributors(owner, repo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}