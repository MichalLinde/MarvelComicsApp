package com.mlinde.marvelcomicsapp.data

import com.mlinde.marvelcomicsapp.api.ApiRensponse
import com.mlinde.marvelcomicsapp.api.ApiService
import kotlin.Exception

class ComicsRepository(private val apiService: ApiService) {

    suspend fun getComics() = apiService.comics()

    suspend fun searchComics(search: String) = apiService.searchComics(search)
}