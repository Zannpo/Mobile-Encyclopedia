package com.example.retrofitencyclopedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.retrofitencyclopedia.Model.Character
import com.example.retrofitencyclopedia.Services.CharacterServices
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToSearch = findViewById<Button>(R.id.buttonCharactersPage)


        goToSearch.setOnClickListener {
            val intent = Intent(this, SearchScreen::class.java)
            startActivity(intent)
        }



    }
}

