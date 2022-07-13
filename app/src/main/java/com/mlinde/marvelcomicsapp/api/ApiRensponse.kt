package com.mlinde.marvelcomicsapp.api

sealed class ApiRensponse<out R>{
    class Success<out T>(val data: T): ApiRensponse<T>()
    class Error(val message: String): ApiRensponse<Nothing>()
}
