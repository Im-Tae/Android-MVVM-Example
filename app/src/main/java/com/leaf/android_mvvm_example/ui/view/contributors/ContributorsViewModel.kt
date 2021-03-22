package com.leaf.android_mvvm_example.ui.view.contributors

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.leaf.android_mvvm_example.base.BaseViewModel
import com.leaf.android_mvvm_example.model.domain.Contributor
import com.leaf.android_mvvm_example.model.repository.ContributorRepository

class ContributorsViewModel(private val contributor: ContributorRepository) : BaseViewModel() {

    private val _contributorList = MutableLiveData<List<Contributor>>()

    val contributorList : LiveData<List<Contributor>>
        get() = _contributorList

    fun getContributors() {
        addDisposable(
            contributor.getContributors("JetBrains", "Kotlin")
                .subscribe({

                    _contributorList.postValue(it)

                }, { Log.e("error", it.message.toString())} )
        )
    }
}