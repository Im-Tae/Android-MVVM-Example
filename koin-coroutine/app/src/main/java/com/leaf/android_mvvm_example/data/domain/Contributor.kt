/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 7:25
 */

package com.leaf.android_mvvm_example.data.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import com.leaf.android_mvvm_example.data.domain.type.ContributorType

@Entity(tableName = "contributor", primaryKeys = ["id"])
data class Contributor(
    @SerializedName("id") @ColumnInfo(name = "id") val id : Int? = null,
    @SerializedName("login") @ColumnInfo(name = "login") val login : String? = null,
    @SerializedName("node_id") @ColumnInfo(name = "node_id") val nodeId : String? = null,
    @SerializedName("avatar_url") @ColumnInfo(name = "avatar_url") val avatarUrl: String? = null,
    @SerializedName("gravatar_id") @ColumnInfo(name = "gravatar_id") val gravatarId: String? = null,
    @SerializedName("url") @ColumnInfo(name = "url") val url : String? = null,
    @SerializedName("html_url") @ColumnInfo(name = "html_url") val htmlUrl : String? = null,
    @SerializedName("followers_url") @ColumnInfo(name = "followers_url") val followersUrl : String? = null,
    @SerializedName("following_url") @ColumnInfo(name = "following_url") val followingUrl : String? = null,
    @SerializedName("gists_url") @ColumnInfo(name = "gists_url") val gistsUrl : String? = null,
    @SerializedName("starred_url") @ColumnInfo(name = "starred_url") val starredUrl : String? = null,
    @SerializedName("subscriptions_url") @ColumnInfo(name = "subscriptions_url") val subscriptionsUrl : String? = null,
    @SerializedName("organizations_url") @ColumnInfo(name = "organizations_url") val organizationsUrl : String? = null,
    @SerializedName("repos_url") @ColumnInfo(name = "repos_url") val reposUrl : String? = null,
    @SerializedName("events_url") @ColumnInfo(name = "events_url") val eventsUrl : String? = null,
    @SerializedName("received_events_url") @ColumnInfo(name = "received_events_url") val receivedEventsUrl : String? = null,
    @SerializedName("type") @ColumnInfo(name = "type") val type : ContributorType? = null,
    @SerializedName("site_admin") @ColumnInfo(name = "site_admin") val siteAdmin : Boolean? = null,
    @SerializedName("contributions") @ColumnInfo(name = "contributions") val contributions : Int? = null
)