/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 5:11
 */

package com.leaf.android_mvvm_example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.leaf.android_mvvm_example.data.domain.Contributor
import com.leaf.android_mvvm_example.data.local.dao.ContributorDao

@Database(entities = [Contributor::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contributorDAO(): ContributorDao
}