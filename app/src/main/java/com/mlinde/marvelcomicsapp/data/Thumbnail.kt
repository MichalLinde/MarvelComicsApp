package com.mlinde.marvelcomicsapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Thumbnail(
    val path: String,
    val extension: String
) : Parcelable{
    @JvmName("getPath1")
    fun getPath() = "$path.$extension"
}
