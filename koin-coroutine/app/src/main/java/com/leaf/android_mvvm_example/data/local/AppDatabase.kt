package com.leaf.android_mvvm_example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leaf.android_mvvm_example.data.domain.Contributor
import com.leaf.android_mvvm_example.data.local.dao.ContributorDao

@Database(entities = [Contributor::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contributorDAO(): ContributorDao
}