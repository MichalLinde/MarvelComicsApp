package com.mlinde.marvelcomicsapp.api

sealed class ApiRensponse<out T>{
    class Success<out T>(val data: T?): ApiRensponse<T>()
    class Error(val message: Throwable): ApiRensponse<Nothing>()
}
