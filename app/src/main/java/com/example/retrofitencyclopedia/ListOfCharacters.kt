package com.example.retrofitencyclopedia

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitencyclopedia.Services.CharacterServices
import androidx.lifecycle.Observer
import com.example.retrofitencyclopedia.Adapters.ListOfCharactersAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.converter.moshi.MoshiConverterFactory

class ListOfCharacters : AppCompatActivity() {
    private lateinit var viewModel:ViewModel
    //private val myAdapter by lazy { ListOfCharactersAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_characters)

        var listView = findViewById<RecyclerView>(R.id.RecyclerViewList)

        listView.apply {
            layoutManager = LinearLayoutManager(this@ListOfCharacters)

            adapter = ListOfCharactersAdapter()
        }

        val BASE_URL = "https://rickandmortyapi.com/api/"
        val httpClient = OkHttpClient()

        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val retrofit: retrofit2.Retrofit = retrofit2.Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        val service: CharacterServices = retrofit.create(CharacterServices::class.java)

        /*service.getStatus("Dead").enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                if (!response.isSuccessful) {
                    Toast.makeText(this@ListOfCharacters, "Błąd połączenia", Toast.LENGTH_LONG)
                        .show()
                    return
                }
                //var listOfWantedCharacters = response.body()!!
                val gson = Gson()
                val characterType: Type = object : TypeToken<ArrayList<Character?>?>() {}.getType()
                val userList: List<Character> = gson.fromJson(response.body().toString(), characterType)
                listView.apply {
                    layoutManager = LinearLayoutManager(this@ListOfCharacters)

                    //adapter = ListOfCharactersAdapter(userList)
                }
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Toast.makeText(this@ListOfCharacters, t.message, Toast.LENGTH_LONG).show()
            }


        }) */

        val repository = Repository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModel::class.java)
        viewModel.getCharactersByStatus("Dead")
        viewModel.charactersByStatus.observe(this, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let {

                }
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

    }


}