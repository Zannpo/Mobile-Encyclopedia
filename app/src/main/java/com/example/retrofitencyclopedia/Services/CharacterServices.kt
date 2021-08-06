package com.example.retrofitencyclopedia.Services

import com.example.retrofitencyclopedia.Model.Character
import com.example.retrofitencyclopedia.Model.Characters
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

public interface CharacterServices {

    @GET("character/")
    fun getAllCharacters():Call<com.example.retrofitencyclopedia.Model.Characters>

    @GET("character/{id}")
    fun getCharacterById(@Path("id") id: Int): Call<com.example.retrofitencyclopedia.Model.Character>

    @GET("character")
    fun getCharactersByName(@Query("name") name : String) :Call<com.example.retrofitencyclopedia.Model.Characters>

    @GET("character")
    fun getCharactersByNameAndStatus(@Query("name") name : String,
    @Query("status")status: String) :Call<com.example.retrofitencyclopedia.Model.Characters>

    @GET("character")
    fun getCharactersbyStatusAndGender(@Query("status") status : String,
                                       @Query("gender") gender : String):Call<com.example.retrofitencyclopedia.Model.Characters>


}