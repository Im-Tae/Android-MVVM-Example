package com.example.android_mvvm_example.ui.view.main

import androidx.lifecycle.MutableLiveData
import com.example.android_mvvm_example.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    var onClickButton = MutableLiveData<Unit>()

    fun openFragment() {
        onClickButton.value = Unit
    }
}