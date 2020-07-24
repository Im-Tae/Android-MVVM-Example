package com.example.android_mvvm_example.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_mvvm_example.R
import com.example.android_mvvm_example.retrofit.domain.Contributor
import com.example.android_mvvm_example.ui.adapter.viewholder.ContributorsViewHolder

class ContributorsAdapter(private val contributorsList: List<Contributor>) : RecyclerView.Adapter<ContributorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorsViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contributors, parent, false)

        return ContributorsViewHolder(itemView)
    }

    override fun getItemCount(): Int = contributorsList.size

    override fun onBindViewHolder(holder: ContributorsViewHolder, position: Int) = holder.bindItems(contributorsList[position])
}