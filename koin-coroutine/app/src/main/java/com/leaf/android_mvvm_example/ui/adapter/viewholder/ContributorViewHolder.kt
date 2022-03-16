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