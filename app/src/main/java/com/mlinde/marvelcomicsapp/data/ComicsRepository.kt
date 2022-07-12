package com.mlinde.marvelcomicsapp.data

import com.mlinde.marvelcomicsapp.api.ApiRensponse
import com.mlinde.marvelcomicsapp.api.ApiService
import kotlin.Exception

class ComicsRepository(private val apiService: ApiService) {

    suspend fun getComics(): ApiRensponse {
        return try {
            //val response = ComicsService.apiService.comics()
            val response = apiService.comics()
            if (response.isSuccessful) {
                ApiRensponse.Success(response.body())
            } else {
                ApiRensponse.Error("Error")
            }
        } catch (exception: Exception) {
            ApiRensponse.Error("Error")
        }
    }

    suspend fun searchComics(search: String): ApiRensponse{
        return try{
            //val response = ComicsService.apiService.searchComics(search)
            val response = apiService.searchComics(search)
            if (response.isSuccessful){
                ApiRensponse.Success(response.body())
            } else{
                ApiRensponse.Error("Error")
            }
        } catch (exception: Exception){
            ApiRensponse.Error("Error")
        }
    }
}