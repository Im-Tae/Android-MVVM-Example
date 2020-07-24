package com.example.android_mvvm_example.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.android_mvvm_example.retrofit.domain.Contributor
import kotlinx.android.synthetic.main.item_contributors.view.*

class ContributorsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindItems(contributorsList: Contributor) {

        itemView.login.text = contributorsList.login
        itemView.user_id.text = contributorsList.id.toString()
    }
}