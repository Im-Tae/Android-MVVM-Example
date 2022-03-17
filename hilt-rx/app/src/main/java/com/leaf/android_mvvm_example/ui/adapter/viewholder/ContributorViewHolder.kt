/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 5:11
 */

package com.leaf.android_mvvm_example.ui.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.leaf.android_mvvm_example.data.domain.Contributor
import com.leaf.android_mvvm_example.databinding.ItemContributorBinding

class ContributorViewHolder(
    private val binding: ItemContributorBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bindItems(contributor: Contributor) {

        binding.login.text = contributor.login
    }
}