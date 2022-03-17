/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 5:11
 */

package com.leaf.android_mvvm_example.ui.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.leaf.android_mvvm_example.base.BaseViewModel
import com.leaf.android_mvvm_example.data.repository.ContributorRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    private val contributorRepository: ContributorRepository
) : BaseViewModel() {

    private val _onClickButton = MutableLiveData<Unit>()
    val onClickButton : LiveData<Unit>
        get() = _onClickButton

    private val _name = MutableLiveData<String>()
    val name : LiveData<String>
        get() = _name

    fun openFragment() {
        _onClickButton.value = Unit
    }

    init {
        viewModelScope.launch {

            contributorRepository.getContributors().collect { contributors ->

                if (!contributors.isNullOrEmpty())
                    _name.postValue(
                        contributors.map { contributor -> contributor.login }
                            .joinToString { name -> "$name\n" }
                            .replace(",", "")
                    )
            }
        }
    }
}