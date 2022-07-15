package com.mlinde.marvelcomicsapp.searchList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlinde.marvelcomicsapp.data.ComicDataWrapper
import com.mlinde.marvelcomicsapp.data.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: RepositoryInterface) : ViewModel() {

    var comicsLiveData = MutableLiveData<ComicDataWrapper>()
    var foundData = MutableLiveData<Boolean>(true)


    fun searchComics(search: String){
        viewModelScope.launch {
            runCatching { repository.searchComics(search) }
                .onSuccess {
//                    comicsLiveData.postValue(ApiResponse.Success(it.body()))
//                    if (it.body()?.data?.results?.isEmpty() == true){
//                        foudnData.postValue(false)
//                    } else{
//                        foudnData.postValue(true)
//                    }
                    comicsLiveData.value = it
                    if (it != null) {
                        foundData.value = it.data.results.isNotEmpty()
                    }
                }
                .onFailure { error: Throwable ->
                    Log.e("Error", "Error", error)
                }
        }
    }
}