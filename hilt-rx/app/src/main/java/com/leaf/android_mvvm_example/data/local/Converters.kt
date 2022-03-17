/*
 * Created by Im-Tae
 *
 * Copyright (c) 2022. Im-Tae.
 * Last modified 22. 3. 16. 오후 5:11
 */

package com.leaf.android_mvvm_example.data.local

import androidx.room.TypeConverter
import com.leaf.android_mvvm_example.data.domain.type.ContributorType

class Converters {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromContributorType(contributorType: ContributorType?) = contributorType?.name

        @TypeConverter
        @JvmStatic
        fun toContributorType(contributorType: String?): ContributorType? = contributorType?.let(ContributorType::valueOf)

    }
}