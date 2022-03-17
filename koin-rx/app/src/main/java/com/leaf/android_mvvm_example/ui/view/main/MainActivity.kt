/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 5:11
 */

package com.leaf.android_mvvm_example.ui.view.main

import android.text.method.ScrollingMovementMethod
import com.leaf.android_mvvm_example.R
import com.leaf.android_mvvm_example.base.BaseActivity
import com.leaf.android_mvvm_example.databinding.ActivityMainBinding
import com.leaf.android_mvvm_example.ui.view.contributors.ContributorFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {

    override val viewModel: MainViewModel by viewModel()

    override fun initLiveData() {

        viewModel.onClickButton.observe(this) {
            showToast("Fragment 열림").let {
                supportFragmentManager
                    .beginTransaction()
                    .add(android.R.id.content, ContributorFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }

        viewModel.name.observe(this) {
            binding.apply {
                textView.movementMethod = ScrollingMovementMethod()
                textView.text = it
            }
        }
    }
}