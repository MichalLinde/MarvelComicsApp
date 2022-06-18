package com.mlinde.marvelcomicsapp.api

sealed class ApiRensponse{
    class Success(val data: Any?): ApiRensponse()
    class Error(val message: String): ApiRensponse()
}
