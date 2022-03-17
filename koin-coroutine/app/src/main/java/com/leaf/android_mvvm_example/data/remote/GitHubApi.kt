/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 7:25
 */

package com.leaf.android_mvvm_example.data.remote

import com.leaf.android_mvvm_example.data.domain.Contributor
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("repos/{owner}/{repo}/contributors")
    suspend fun getObContributors(@Path("owner") owner: String, @Path("repo") repo: String) : Response<List<Contributor>>
}