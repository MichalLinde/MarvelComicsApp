package com.mlinde.marvelcomicsapp.comicsList

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

    var comicsLiveData: MutableLiveData<ComicDataWrapper> = MutableLiveData()
    var messageLiveData: MutableLiveData<String> = MutableLiveData()

    fun getComics(){
        viewModelScope.launch {
            when(val response = repository.getComics()){
                is ApiRensponse.Success ->{
                    comicsLiveData.postValue(response.data as ComicDataWrapper)
                }
                is ApiRensponse.Error -> {
                    messageLiveData.postValue(response.message)
                }
            }
        }
    }

}