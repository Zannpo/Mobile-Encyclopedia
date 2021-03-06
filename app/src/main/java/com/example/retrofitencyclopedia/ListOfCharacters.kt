package com.example.retrofitencyclopedia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitencyclopedia.Adapters.ListOfCharactersAdapter
import com.example.retrofitencyclopedia.Model.Character
import com.example.retrofitencyclopedia.Model.Characters
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_characters)

        val goBack = findViewById<Button>(R.id.buttonGoToMenu4)

        goBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var listView = findViewById<RecyclerView>(R.id.RecyclerViewList)

        val wantedCharacter = intent.getStringExtra("characterName")
        val wantedMode = intent.getStringExtra("Mode")
        val wantedGender = intent.getStringExtra("characterGender")
        val wantedStatus = intent.getStringExtra("characterStatus")

        if (wantedCharacter.isNullOrEmpty()) {

            if (!wantedMode.isNullOrEmpty()) {
                //Wyświetl liste wszystkich postaci
                var service = Retrofit().createCharacterService().getAllCharacters()
                service.enqueue(object : Callback<Characters> {


                    override fun onFailure(call: Call<Characters>, t: Throwable) {
                        Toast.makeText(this@ListOfCharacters, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<Characters>,
                        response: Response<Characters>
                    ) {
                        if (!response.isSuccessful) {
                            Toast.makeText(
                                this@ListOfCharacters,
                                "Błąd połączenia",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }

                        val list = response.body()

                        list?.let {
                            listView.apply {
                                layoutManager = LinearLayoutManager(this@ListOfCharacters)

                                adapter = ListOfCharactersAdapter(list)

                            }
                        }


                        return
                    }

                })
            }
            else if (!wantedStatus.isNullOrEmpty() && !wantedGender.isNullOrEmpty())
            {
                if(wantedStatus.equals("Alive", ignoreCase = true))
                {
                    if(wantedGender.equals("Female", ignoreCase = true))
                    {
                        var service = Retrofit().createCharacterService().getCharactersbyStatusAndGender("Alive","Female")

                        service.enqueue(object : Callback<Characters> {


                            override fun onFailure(call: Call<Characters>, t: Throwable) {
                                Toast.makeText(this@ListOfCharacters, t.message, Toast.LENGTH_LONG).show()
                            }

                            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                                if (!response.isSuccessful) {
                                    Toast.makeText(this@ListOfCharacters, "Błąd połączenia", Toast.LENGTH_LONG)
                                            .show()
                                }

                                val list = response.body()

                                list?.let {
                                    listView.apply {
                                        layoutManager = LinearLayoutManager(this@ListOfCharacters)

                                        adapter = ListOfCharactersAdapter(list)

                                    }
                                }


                                return
                            }

                        })
                    }
                    else
                    {
                        var service = Retrofit().createCharacterService().getCharactersbyStatusAndGender("Alive","Male")
                        service.enqueue(object : Callback<Characters> {


                            override fun onFailure(call: Call<Characters>, t: Throwable) {
                                Toast.makeText(this@ListOfCharacters, t.message, Toast.LENGTH_LONG).show()
                            }

                            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                                if (!response.isSuccessful) {
                                    Toast.makeText(this@ListOfCharacters, "Błąd połączenia", Toast.LENGTH_LONG)
                                            .show()
                                }

                                val list = response.body()

                                list?.let {
                                    listView.apply {
                                        layoutManager = LinearLayoutManager(this@ListOfCharacters)

                                        adapter = ListOfCharactersAdapter(list)

                                    }
                                }


                                return
                            }

                        })
                    }
                }
                else {
                    if (wantedGender.equals("Female", ignoreCase = true))
                    {
                        var service = Retrofit().createCharacterService().getCharactersbyStatusAndGender("Dead","Female")
                        service.enqueue(object : Callback<Characters> {


                            override fun onFailure(call: Call<Characters>, t: Throwable) {
                                Toast.makeText(this@ListOfCharacters, t.message, Toast.LENGTH_LONG).show()
                            }

                            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                                if (!response.isSuccessful) {
                                    Toast.makeText(this@ListOfCharacters, "Błąd połączenia", Toast.LENGTH_LONG)
                                            .show()
                                }

                                val list = response.body()

                                list?.let {
                                    listView.apply {
                                        layoutManager = LinearLayoutManager(this@ListOfCharacters)

                                        adapter = ListOfCharactersAdapter(list)

                                    }
                                }


                                return
                            }

                        })
                    }
                    else
                    {
                        var service = Retrofit().createCharacterService().getCharactersbyStatusAndGender("Dead","Male")
                        service.enqueue(object : Callback<Characters> {


                            override fun onFailure(call: Call<Characters>, t: Throwable) {
                                Toast.makeText(this@ListOfCharacters, t.message, Toast.LENGTH_LONG).show()
                            }

                            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                                if (!response.isSuccessful) {
                                    Toast.makeText(this@ListOfCharacters, "Błąd połączenia", Toast.LENGTH_LONG)
                                            .show()
                                }

                                val list = response.body()

                                list?.let {
                                    listView.apply {
                                        layoutManager = LinearLayoutManager(this@ListOfCharacters)

                                        adapter = ListOfCharactersAdapter(list)

                                    }
                                }


                                return
                            }

                        })
                    }
                }


            }


        }
        else
        {
            if (wantedStatus.isNullOrEmpty())
            {
                //Wyświetl liste postaci według imienia
                var service = Retrofit().createCharacterService().getCharactersByName(wantedCharacter)
                service.enqueue(object : Callback<Characters> {


                    override fun onFailure(call: Call<Characters>, t: Throwable) {
                        Toast.makeText(this@ListOfCharacters, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                        if (!response.isSuccessful) {
                            Toast.makeText(this@ListOfCharacters, "Błąd połączenia", Toast.LENGTH_LONG)
                                    .show()
                        }

                        val list = response.body()

                        list?.let {
                            listView.apply {
                                layoutManager = LinearLayoutManager(this@ListOfCharacters)

                                adapter = ListOfCharactersAdapter(list)

                            }
                        }


                        return
                    }

                })
            }
            else
            {
                if(wantedStatus.equals("Alive", ignoreCase = true))
                {
                    var service = Retrofit().createCharacterService().getCharactersByNameAndStatus(wantedCharacter,"Alive")
                    service.enqueue(object : Callback<Characters> {


                        override fun onFailure(call: Call<Characters>, t: Throwable) {
                            Toast.makeText(this@ListOfCharacters, t.message, Toast.LENGTH_LONG).show()
                        }

                        override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                            if (!response.isSuccessful) {
                                Toast.makeText(this@ListOfCharacters, "Błąd połączenia", Toast.LENGTH_LONG)
                                        .show()
                            }

                            val list = response.body()

                            list?.let {
                                listView.apply {
                                    layoutManager = LinearLayoutManager(this@ListOfCharacters)

                                    adapter = ListOfCharactersAdapter(list)

                                }
                            }


                            return
                        }

                    })
                }
                else
                {
                    var service = Retrofit().createCharacterService().getCharactersByNameAndStatus(wantedCharacter,"Dead")
                    service.enqueue(object : Callback<Characters> {


                        override fun onFailure(call: Call<Characters>, t: Throwable) {
                            Toast.makeText(this@ListOfCharacters, t.message, Toast.LENGTH_LONG).show()
                        }

                        override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                            if (!response.isSuccessful) {
                                Toast.makeText(this@ListOfCharacters, "Błąd połączenia", Toast.LENGTH_LONG)
                                        .show()
                            }

                            val list = response.body()

                            list?.let {
                                listView.apply {
                                    layoutManager = LinearLayoutManager(this@ListOfCharacters)

                                    adapter = ListOfCharactersAdapter(list)

                                }
                            }


                            return
                        }

                    })
                }

            }

        }
    }
}

