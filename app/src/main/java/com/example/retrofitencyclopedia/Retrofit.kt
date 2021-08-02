package com.example.retrofitencyclopedia

import com.example.retrofitencyclopedia.Services.CharacterServices
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.converter.moshi.MoshiConverterFactory

@Component
object Retrofit {
    val BASE_URL = "https://rickandmortyapi.com/api/"
    val httpClient = OkHttpClient()

    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val retrofit: retrofit2.Retrofit = retrofit2.Retrofit.Builder()
        .client(httpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    //val service: CharacterServices = retrofit.create(CharacterServices::class.java)

    val api: CharacterServices by lazy {
        retrofit.create(CharacterServices::class.java)
    }
}