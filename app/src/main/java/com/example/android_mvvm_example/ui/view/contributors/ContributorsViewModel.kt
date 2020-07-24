package com.example.android_mvvm_example.ui.view.contributors

import com.example.android_mvvm_example.base.BaseViewModel
import com.example.android_mvvm_example.retrofit.domain.Contributor
import com.example.android_mvvm_example.retrofit.network.GitHubApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

class ContributorsViewModel : BaseViewModel() {

    private val gitHubApi: GitHubApi by inject { parametersOf(this) }

    private val contributorList = mutableListOf<List<Contributor>>()

    fun getContributors() {
        addDisposable(
            gitHubApi.getObContributors("JetBrains", "Kotlin")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    contributorList.add(it)
                }, {})
        )
    }
}