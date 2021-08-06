package com.example.retrofitencyclopedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SearchScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_screen)

        Toast.makeText(this@SearchScreen, "Wypełnij tylko jedno pole!", Toast.LENGTH_LONG).show()

        val goToCharacterCardPage = findViewById<Button>(R.id.buttonSearch)
        val goToCharactersList = findViewById<Button>(R.id.buttonSearchList)
        val number = findViewById<EditText>(R.id.editTextIdNumber)
        val searchName = findViewById<EditText>(R.id.editTextTextPersonName)
        val radioGender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val radioStatus = findViewById<RadioGroup>(R.id.radioGroupStatus)
        val radioMale = findViewById<RadioButton>(R.id.radioButtonMale)
        val radioFemale = findViewById<RadioButton>(R.id.radioButtonFemale)
        val radioAlive = findViewById<RadioButton>(R.id.radioButtonAlive)
        val radioDead = findViewById<RadioButton>(R.id.radioButtonDead)

        var defaultRadioStatus = radioAlive.getId()
        radioStatus.check(defaultRadioStatus)

        var defaultRadioGender = radioFemale.getId()
        radioStatus.check(defaultRadioGender)

        goToCharacterCardPage.setOnClickListener {
            val intent = Intent(this, CharactersPage::class.java)

            //Wyszukaj według id
            if(number.text.isNotBlank())
            {
                var wantedId = number.text
                intent.putExtra("characterId",wantedId.toString())
                startActivity(intent)
            }


        }

        goToCharactersList.setOnClickListener {
            val intent = Intent(this, ListOfCharacters::class.java)



            if(searchName.text.isNotBlank() && radioAlive.isChecked == false && radioDead.isChecked == false)
            {
                var wantedCharacter = searchName.text
                intent.putExtra("characterName",wantedCharacter.toString())
                startActivity(intent)
            }
            else if (radioAlive.isChecked == true && searchName.text.isNotBlank())
            {
                var status = "alive"
                var wantedCharacter = searchName.text
                intent.putExtra("characterStatus",status.toString())
                intent.putExtra("characterName",wantedCharacter.toString())
                startActivity(intent)
            }
            else if (radioDead.isChecked == true && searchName.text.isNotBlank())
            {
                var status = "dead"
                var wantedCharacter = searchName.text
                intent.putExtra("characterStatus",status.toString())
                intent.putExtra("characterName",wantedCharacter.toString())
                startActivity(intent)
            }
            else if (radioFemale.isChecked == true && radioAlive.isChecked == true && !searchName.text.isNotBlank())
            {
                var status = "alive"
                var gender = "female"
                intent.putExtra("characterStatus",status.toString())
                intent.putExtra("characterGender",gender.toString())
                startActivity(intent)
            }
            else if (radioMale.isChecked == true && radioDead.isChecked == true && !searchName.text.isNotBlank())
            {
                var status = "dead"
                var gender = "male"
                intent.putExtra("characterStatus",status.toString())
                intent.putExtra("characterGender",gender.toString())
                startActivity(intent)
            }


        }


        }
}