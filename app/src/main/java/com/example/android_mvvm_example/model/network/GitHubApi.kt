package com.example.android_mvvm_example.model.network

import com.example.android_mvvm_example.model.domain.Contributor
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("repos/{owner}/{repo}/contributors")
    fun getObContributors(@Path("owner") owner: String, @Path("repo") repo: String) : Single<List<Contributor>>
}