package com.leaf.android_mvvm_example.ui.view.main

import android.os.Bundle
import androidx.lifecycle.Observer
import com.leaf.android_mvvm_example.R
import com.leaf.android_mvvm_example.base.BaseActivity
import com.leaf.android_mvvm_example.databinding.ActivityMainBinding
import com.leaf.android_mvvm_example.ui.view.contributors.ContributorsFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {

    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.onClickButton.observe(this, Observer {
            showToast("Fragment 열림").let {
                supportFragmentManager
                    .beginTransaction()
                    .add(android.R.id.content,
                        ContributorsFragment()
                    )
                    .addToBackStack(null)
                    .commit()
            }
        })
    }
}