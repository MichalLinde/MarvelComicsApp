package com.mlinde.marvelcomicsapp.api

import com.mlinde.marvelcomicsapp.data.ComicDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("comics")
    suspend fun comics(): Response<ComicDataWrapper>

    @GET("comics")
    suspend fun searchComics(@Query("titleStartsWith") titleStartsWith: String):
            Response<ComicDataWrapper>
}