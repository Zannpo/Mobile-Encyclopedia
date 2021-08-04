package com.example.retrofitencyclopedia

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitencyclopedia.Adapters.ListOfCharactersAdapter
import com.example.retrofitencyclopedia.Model.Character
import com.example.retrofitencyclopedia.Services.CharacterServices
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.internal.notify
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.moshi.MoshiConverterFactory

class ListOfCharacters : AppCompatActivity() {
    private lateinit var viewModel:ViewModel
    //private val myAdapter by lazy { ListOfCharactersAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_characters)

        var listView = findViewById<RecyclerView>(R.id.RecyclerViewList)



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

        /*val repository = Repository()
        val viewModelFactory = ViewModelFactory(repository)
       viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModel::class.java)
        viewModel.getCharactersByStatus("Alive")
        viewModel.charactersByStatus.observe(this, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let {
                    ListOfCharactersAdapter().setData(it)
                }
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })*/
        service.getAliveCharactersByName("rick").enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                if (!response.isSuccessful) {
                    Toast.makeText(this@ListOfCharacters, "Błąd połączenia", Toast.LENGTH_LONG)
                            .show()

                    var list: List<Character> = ArrayList()
                    list = listOf(response.body()) as List<Character>
                    listView.apply {
                        layoutManager = LinearLayoutManager(this@ListOfCharacters)

                        adapter = ListOfCharactersAdapter(list)

                    }

                    return
                }

            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Toast.makeText(this@ListOfCharacters, t.message, Toast.LENGTH_LONG).show()
            }


        })


    }


}