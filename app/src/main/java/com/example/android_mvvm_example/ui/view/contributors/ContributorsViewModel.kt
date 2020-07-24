package com.example.android_mvvm_example.ui.view.contributors

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.android_mvvm_example.base.BaseViewModel
import com.example.android_mvvm_example.retrofit.domain.Contributor
import com.example.android_mvvm_example.retrofit.network.GitHubApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

class ContributorsViewModel : BaseViewModel() {

    private val gitHubApi: GitHubApi by inject { parametersOf(this) }

    val contributorList = MutableLiveData<List<Contributor>>()

    fun getContributors() {
        addDisposable(
            gitHubApi.getObContributors("JetBrains", "Kotlin")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    contributorList.postValue(it)
                }, { Log.e("error", it.message.toString())} )
        )
    }
}