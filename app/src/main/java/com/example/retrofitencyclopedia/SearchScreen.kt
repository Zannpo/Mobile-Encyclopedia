package com.example.retrofitencyclopedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SearchScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_screen)

        val goToCharacterCardPage = findViewById<Button>(R.id.buttonSearch)
        val goToCharactersList = findViewById<Button>(R.id.buttonSearchList)
        val number = findViewById<EditText>(R.id.editTextIdNumber)

        val searchName = findViewById<EditText>(R.id.editTextTextPersonName)

        Toast.makeText(this@SearchScreen, "Wypełnił tylko jedno pole!", Toast.LENGTH_LONG).show()

        goToCharacterCardPage.setOnClickListener {
            val intent = Intent(this, CharactersPage::class.java)

            //Wyszukaj według id
            if(number.text.isNotBlank())
            {
                var wantedId = number.text
                intent.putExtra("characterId",wantedId.toString())
                startActivity(intent)
            }

            //Wyszukaj według imienia
            if(searchName.text.isNotBlank())
            {
                var wantedCharacter = searchName.text
                intent.putExtra("characterName",wantedCharacter.toString())
                startActivity(intent)
            }



        }

        goToCharactersList.setOnClickListener {
            val intent = Intent(this, ListOfCharacters::class.java)



            if(searchName.text.isNotBlank())
            {
                var wantedCharacter = searchName.text
                intent.putExtra("characterName",wantedCharacter.toString())
                startActivity(intent)
            }

            startActivity(intent)

        }


        }
}