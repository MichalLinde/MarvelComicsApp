package com.mlinde.marvelcomicsapp.comicsList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlinde.marvelcomicsapp.api.ApiRensponse
import com.mlinde.marvelcomicsapp.data.ComicDataWrapper
import com.mlinde.marvelcomicsapp.data.ComicsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsListViewModel @Inject constructor(private val repository: ComicsRepository): ViewModel() {

    var comicsLiveData = MutableLiveData<ApiRensponse<ComicDataWrapper>>()

    fun getComics(){
        viewModelScope.launch {

            runCatching { repository.getComics() }
                .onSuccess {
                    comicsLiveData.postValue(ApiRensponse.Success(it.body()))
                }
                .onFailure {
                    comicsLiveData.postValue(ApiRensponse.Error(it))
//                    Log.e("Error", "Error", error)
                }
        }
    }
}