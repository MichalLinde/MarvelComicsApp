package com.mlinde.marvelcomicsapp.searchList

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
class SearchViewModel @Inject constructor(private val repository: ComicsRepository) : ViewModel() {

    var comicsLiveData: MutableLiveData<ComicDataWrapper?> = MutableLiveData()
    var messageLiveData: MutableLiveData<String> = MutableLiveData()
    var foudnData = MutableLiveData<Boolean>(true)

    fun searchComics(search: String){
        //val business = Comics(search)
        viewModelScope.launch {
            when(val response = repository.searchComics(search)){
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