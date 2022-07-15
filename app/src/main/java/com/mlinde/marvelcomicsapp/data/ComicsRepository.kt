package com.mlinde.marvelcomicsapp.data

import com.mlinde.marvelcomicsapp.api.ApiService
import retrofit2.HttpException
import retrofit2.Response

class ComicsRepository(private val apiService: ApiService): RepositoryInterface {

    override suspend fun getComics(): ComicDataWrapper? {
        val response = apiService.comics()
        if (!response.isSuccessful){
            throw HttpException(response)
        }
        return response.body()
    }

    override suspend fun searchComics(search: String): ComicDataWrapper?{
        val response = apiService.searchComics(search)
        if (!response.isSuccessful){
            throw HttpException(response)
        }
        return response.body()
    }
}

interface RepositoryInterface{

    suspend fun getComics() : ComicDataWrapper?
    suspend fun searchComics(search: String): ComicDataWrapper?
}