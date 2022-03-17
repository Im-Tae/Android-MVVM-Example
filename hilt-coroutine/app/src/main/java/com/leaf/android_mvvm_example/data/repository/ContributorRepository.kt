/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 5:11
 */

package com.leaf.android_mvvm_example.data.repository

import com.leaf.android_mvvm_example.data.ApiResponse
import com.leaf.android_mvvm_example.data.ResponseBody
import com.leaf.android_mvvm_example.data.domain.Contributor
import com.leaf.android_mvvm_example.data.local.dao.ContributorDao
import com.leaf.android_mvvm_example.data.remote.GitHubApi
import javax.inject.Inject

class ContributorRepository @Inject constructor(
    private val gitHubApi: GitHubApi,
    private val contributorDao: ContributorDao
) {

    suspend fun getContributors(owner: String, repo: String): ResponseBody<List<Contributor>> {
        return try {
            ApiResponse.create(gitHubApi.getObContributors(owner, repo)).apply {
                if (!body.isNullOrEmpty()) insertContributors(*body.toTypedArray())
            }
        } catch (e: Exception) {
            ApiResponse.create(e)
        }
    }

    fun getContributors() = contributorDao.getContributors()

    private suspend fun insertContributors(vararg name: Contributor) = contributorDao.insertContributors(*name)

}