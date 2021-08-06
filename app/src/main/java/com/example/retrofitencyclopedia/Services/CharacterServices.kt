package com.example.retrofitencyclopedia.Services

import com.example.retrofitencyclopedia.Model.Character
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

public interface CharacterServices {

    @GET("character/{id}")
    fun getCharacterById(@Path("id") id: Int): Call<com.example.retrofitencyclopedia.Model.Character>

    @GET("/character/?name={name}")
    fun getCharacterByName(@Path("name") name: String): Call<List<com.example.retrofitencyclopedia.Model.Character>>


    @GET("/character/?")
    fun getAliveCharactersByName(@Query(value = "name", encoded = true) name: String?):Call<com.example.retrofitencyclopedia.Model.Character>

    @GET("character/")
    fun getAllCharacters():Call<com.example.retrofitencyclopedia.Model.Characters>

}