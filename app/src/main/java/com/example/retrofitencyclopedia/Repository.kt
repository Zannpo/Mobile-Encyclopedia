package com.example.retrofitencyclopedia

import com.example.retrofitencyclopedia.Model.Character
import retrofit2.Call
import retrofit2.Response

class Repository {

    suspend fun getStatus(status: String): Response<List<Character>> {
        return Retrofit.api.getStatus(status)
    }

    /*fun getAliveCharactersByName(name: String): Call<List<Character>>? {
        return Retrofit.api.getAListOfCharactersByStatus(name)
    }*/
}