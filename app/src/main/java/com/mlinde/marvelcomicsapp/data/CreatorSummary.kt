package com.mlinde.marvelcomicsapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreatorSummary(
    val name: String,
    val role: String
) : Parcelable
