package com.leaf.android_mvvm_example.ui.view.contributors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.leaf.android_mvvm_example.base.BaseViewModel
import com.leaf.android_mvvm_example.data.ResponseType
import com.leaf.android_mvvm_example.data.domain.Contributor
import com.leaf.android_mvvm_example.data.repository.ContributorRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class ContributorViewModel(
    private val contributorRepository: ContributorRepository
) : BaseViewModel() {

    private val _contributorList = MutableLiveData<List<Contributor>>()
    val contributorList : LiveData<List<Contributor>>
        get() = _contributorList

    private val _showProgress = MutableLiveData<Boolean>()
    val showProgress : LiveData<Boolean>
        get() = _showProgress

    fun getContributors(owner: String, repo: String) {

        _showProgress.postValue(true)
        _contributorList.postValue(listOf())

        viewModelScope.launch {

            val contributorResponse = contributorRepository.getContributors(owner, repo)

            if (contributorResponse.result == ResponseType.SUCCESS) {

                contributorResponse.body?.let {

                    _contributorList.postValue(it)
                    _showProgress.postValue(false)
                }
            } else {
                Timber.e("error : ${contributorResponse.message}")
                _showProgress.postValue(false)
            }
        }
    }
}