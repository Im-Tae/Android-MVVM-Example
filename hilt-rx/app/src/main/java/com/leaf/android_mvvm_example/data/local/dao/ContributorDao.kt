/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 7:41
 */

package com.leaf.android_mvvm_example.data.local.dao

import androidx.room.*
import com.leaf.android_mvvm_example.data.domain.Contributor
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface ContributorDao {

    @Query("SELECT * FROM contributor")
    fun getContributors(): Flowable<List<Contributor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContributors(vararg name: Contributor): Completable

    @Update
    fun updateContributor(name: Contributor): Completable

    @Query("DELETE FROM contributor")
    fun deleteAll(): Completable
}