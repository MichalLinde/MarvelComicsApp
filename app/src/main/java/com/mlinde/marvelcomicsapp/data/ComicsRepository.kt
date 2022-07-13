package com.mlinde.marvelcomicsapp.data

import com.mlinde.marvelcomicsapp.api.ApiService
import retrofit2.HttpException
import retrofit2.Response

class ComicsRepository(private val apiService: ApiService) {

    suspend fun getComics(): Response<ComicDataWrapper> {
        val response = apiService.comics()
        if (!response.isSuccessful){
            throw HttpException(response)
        }
        return response
    }

    suspend fun searchComics(search: String): Response<ComicDataWrapper>{
        val response = apiService.searchComics(search)
        if (!response.isSuccessful){
            throw HttpException(response)
        }
        return response
    }
}