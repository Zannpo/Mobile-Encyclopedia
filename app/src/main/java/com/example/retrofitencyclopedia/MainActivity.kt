package com.example.retrofitencyclopedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToSearch = findViewById<Button>(R.id.buttonCharactersPage)
        val goToEncyclopedia = findViewById<Button>(R.id.buttonEncyclopedia)
        val goToInfo = findViewById<Button>(R.id.buttonInfo)
        val goToListView = findViewById<Button>(R.id.buttonListView)

        goToSearch.setOnClickListener {
            val intent = Intent(this, SearchScreen::class.java)
            startActivity(intent)
        }
        goToInfo.setOnClickListener {
            val intent = Intent(this, Information::class.java)
            startActivity(intent)
        }
        goToEncyclopedia.setOnClickListener {
            val intent = Intent(this, CharactersSwitchPages::class.java)
            startActivity(intent)
        }

        goToListView.setOnClickListener {
            val intent = Intent(this, ListOfCharacters::class.java)
            startActivity(intent)
        }
    }
}

