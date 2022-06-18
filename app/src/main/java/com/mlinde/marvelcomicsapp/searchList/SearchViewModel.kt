package com.mlinde.marvelcomicsapp.searchList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlinde.marvelcomicsapp.api.ApiRensponse
import com.mlinde.marvelcomicsapp.data.Comics
import com.mlinde.marvelcomicsapp.data.ComicDataWrapper
import kotlinx.coroutines.launch

class SearchViewModel() : ViewModel() {

    var comicsLiveData: MutableLiveData<ComicDataWrapper?> = MutableLiveData()
    var messageLiveData: MutableLiveData<String> = MutableLiveData()
    var foudnData = MutableLiveData<Boolean>(true)

    fun searchComics(search: String){
        val business = Comics(search)
        viewModelScope.launch {
            when(val response = business.searchComics(search)){
                is ApiRensponse.Success ->{
                    comicsLiveData.postValue(response.data as ComicDataWrapper)
                    if (response.data.data.results.isEmpty()){
                        foudnData.postValue(false)
                    } else{
                        foudnData.postValue(true)
                    }
                }
                is ApiRensponse.Error -> {
                    messageLiveData.postValue(response.message)
                }
            }
        }
    }
}