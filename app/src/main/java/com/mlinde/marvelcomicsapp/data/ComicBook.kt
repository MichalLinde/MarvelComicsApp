package com.mlinde.marvelcomicsapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ComicBook(
    val id: Int,
    val title: String,
    val description: String?,
    val thumbnail: Thumbnail,
    val images: List<Image>,
    val creators: CreatorList,
    val urls: List<Url>
) : Parcelable

