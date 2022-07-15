package com.mlinde.marvelcomicsapp.comicsList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlinde.marvelcomicsapp.api.ApiResponse
import com.mlinde.marvelcomicsapp.data.ComicDataWrapper
import com.mlinde.marvelcomicsapp.data.ComicsRepository
import com.mlinde.marvelcomicsapp.data.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsListViewModel @Inject constructor(private val repository: RepositoryInterface): ViewModel() {

    var comicsLiveData = MutableLiveData<ComicDataWrapper?>()

    fun getComics(){
        viewModelScope.launch {

            runCatching { repository.getComics() }
                .onSuccess {
                    comicsLiveData.value = it
                }
                .onFailure {
                    //comicsLiveData.postValue(it)
                }
        }
    }
}