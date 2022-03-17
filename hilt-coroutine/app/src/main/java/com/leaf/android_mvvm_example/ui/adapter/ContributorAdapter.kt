/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 5:11
 */

package com.leaf.android_mvvm_example.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.leaf.android_mvvm_example.R
import com.leaf.android_mvvm_example.data.domain.Contributor
import com.leaf.android_mvvm_example.databinding.ItemContributorBinding
import com.leaf.android_mvvm_example.ui.adapter.viewholder.ContributorViewHolder

class ContributorAdapter() : ListAdapter<Contributor, ContributorViewHolder>(
    DiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contributor, parent, false)

        return ContributorViewHolder(ItemContributorBinding.bind(itemView))
    }

    override fun onBindViewHolder(holder: ContributorViewHolder, position: Int) = holder.bindItems(getItem(position))

    private class DiffCallback : DiffUtil.ItemCallback<Contributor>() {

        override fun areItemsTheSame(oldItem: Contributor, newItem: Contributor): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contributor, newItem: Contributor): Boolean {
            return oldItem == newItem
        }
    }
}