package com.mlinde.marvelcomicsapp.api

sealed class ApiResponse<out T>{
    class Success<out T>(val data: T?): ApiResponse<T>()
    class Error(val message: Throwable): ApiResponse<Nothing>()
}
