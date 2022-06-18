package com.mlinde.marvelcomicsapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreatorList(
    val returned: Int,
    val items: List<CreatorSummary>
) : Parcelable
