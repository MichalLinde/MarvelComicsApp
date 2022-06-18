package com.mlinde.marvelcomicsapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val extension: String,
    val path: String
) : Parcelable
