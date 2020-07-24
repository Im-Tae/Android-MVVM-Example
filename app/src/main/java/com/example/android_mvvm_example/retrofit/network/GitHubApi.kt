package com.example.android_mvvm_example.retrofit.network

import com.example.android_mvvm_example.retrofit.domain.Contributor
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("repos/{owner}/{repo}/contributors")
    fun getObContributors(@Path("owner") owner: String, @Path("repo") repo: String) : Observable<List<Contributor>>
}