package com.example.retrofitencyclopedia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitencyclopedia.Model.Character
import com.example.retrofitencyclopedia.Services.CharacterServices
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.moshi.MoshiConverterFactory


class CharactersPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_page)

        val goToMenu = findViewById<Button>(R.id.buttonGoToMenu1)
        val goBack = findViewById<Button>(R.id.buttonGoOnePageBack)

        goToMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        goBack.setOnClickListener {
            val intent = Intent(this, SearchScreen::class.java)
            startActivity(intent)
        }


        val wantedId = intent.getStringExtra("characterId")


        if(!wantedId.isNullOrEmpty()) {
            var service = Retrofit().createCharacterService().getCharacterById(Integer.parseInt(wantedId))
            service.enqueue(object : Callback<Character> {
                override fun onResponse(call: Call<Character>, response: Response<Character>) {
                    if (!response.isSuccessful) {
                        Toast.makeText(this@CharactersPage, "Błąd połączenia", Toast.LENGTH_LONG).show()
                        return
                    }

                    val foundCharacter = response.body()!!
                    val name = foundCharacter.name
                    val status = foundCharacter.status
                    val gender = foundCharacter.gender
                    val avatar = foundCharacter.image
                    val species = foundCharacter.species

                    val characterName = findViewById<TextView>(R.id.textViewName)
                    val characterStatus = findViewById<TextView>(R.id.textViewStatus)
                    val characterSpecies = findViewById<TextView>(R.id.textViewSpecies)
                    val characterGender = findViewById<TextView>(R.id.textViewGender)
                    val characterAvatar = findViewById<ImageView>(R.id.imageViewAvatar)

                    //Ustawienie danych
                    characterName.text = name
                    characterStatus.text = status
                    characterSpecies.text = species
                    characterGender.text = gender
                    Picasso.with(this@CharactersPage).load(avatar).into(characterAvatar);

                }

                override fun onFailure(call: Call<Character>, t: Throwable) {

                    Toast.makeText(this@CharactersPage, t.message, Toast.LENGTH_LONG).show()

                }


            })
        }


    }
}