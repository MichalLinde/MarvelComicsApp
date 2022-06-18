package com.mlinde.marvelcomicsapp.data

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ComicBook(
    val id: Int,
    val title: String,
    val description: String?,
    val thumbnail: Thumbnail,
    val images: List<Image>,
    val creators: CreatorList,
    val resourceURI: String,
    val pageCount: Int
) : Parcelable

