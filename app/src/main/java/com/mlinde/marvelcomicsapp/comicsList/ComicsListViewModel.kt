package com.mlinde.marvelcomicsapp.comicsList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlinde.marvelcomicsapp.api.ApiRensponse
import com.mlinde.marvelcomicsapp.data.Comics
import com.mlinde.marvelcomicsapp.data.ComicDataWrapper
import kotlinx.coroutines.launch

class ComicsListViewModel : ViewModel() {

    private val search: String? = null
    private val business = Comics(search)
    var comicsLiveData: MutableLiveData<ComicDataWrapper> = MutableLiveData()
    var messageLiveData: MutableLiveData<String> = MutableLiveData()

    fun getComics(){
        viewModelScope.launch {
            when(val response = business.getComics()){
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