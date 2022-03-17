/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 7:41
 */

package com.leaf.android_mvvm_example.data.local.dao

import androidx.room.*
import com.leaf.android_mvvm_example.data.domain.Contributor
import kotlinx.coroutines.flow.Flow

@Dao
interface ContributorDao {

    @Query("SELECT * FROM contributor")
    fun getContributors(): Flow<List<Contributor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContributors(vararg name: Contributor)

    @Update
    suspend fun updateContributor(name: Contributor)
}