package com.mlinde.marvelcomicsapp.data

class Comics(var search: String?){

    private val repo by lazy { ComicsRepository() }
    suspend fun getComics() = repo.getComics()
    suspend fun searchComics(string: String?) = repo.searchComics(search.toString())
}