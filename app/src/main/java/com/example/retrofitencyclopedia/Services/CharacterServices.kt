package com.example.retrofitencyclopedia.Services

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

public interface CharacterServices {

    @GET("character/{id}")
    fun getCharacterById(@Path("id") id: Int): Call<com.example.retrofitencyclopedia.Model.Character>

    @GET("/character/?name={name}")
    fun getCharacterByName(@Path("name") name: String): Call<com.example.retrofitencyclopedia.Model.Character>

    @GET("/character/?name=rick")
    fun getRickByName(): Call<com.example.retrofitencyclopedia.Model.Character>

    @GET("character/{status}")
    fun getAListOfCharacters(@Path("status") status: String?): Call<List<com.example.retrofitencyclopedia.Model.Character?>?>?
}