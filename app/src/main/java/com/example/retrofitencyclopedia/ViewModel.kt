package com.example.retrofitencyclopedia

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitencyclopedia.Model.Character
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModel(private val repository: Repository): ViewModel() {
    var charactersByStatus: MutableLiveData<Response<List<Character>>> = MutableLiveData()

    fun getCharactersByStatus(status: String) {
        viewModelScope.launch {
            val response = repository.getStatus(status)
            charactersByStatus.value = response
        }
    }


}