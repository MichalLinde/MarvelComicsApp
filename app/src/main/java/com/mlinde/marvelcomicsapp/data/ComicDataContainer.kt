package com.mlinde.marvelcomicsapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ComicDataContainer(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ComicBook>,
    val total: Int
): Parcelable
