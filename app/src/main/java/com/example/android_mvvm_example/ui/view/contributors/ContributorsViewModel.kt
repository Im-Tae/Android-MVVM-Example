package com.example.android_mvvm_example.ui.view.contributors

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.android_mvvm_example.base.BaseViewModel
import com.example.android_mvvm_example.model.domain.Contributor
import com.example.android_mvvm_example.model.repository.ContributorRepository

class ContributorsViewModel(private val contributor: ContributorRepository) : BaseViewModel() {

    var contributorList = MutableLiveData<List<Contributor>>()

    fun getContributors() {
        addDisposable(
            contributor.getContributors("JetBrains", "Kotlin")
                .subscribe({

                    contributorList.postValue(it)

                }, { Log.e("error", it.message.toString())} )
        )
    }
}