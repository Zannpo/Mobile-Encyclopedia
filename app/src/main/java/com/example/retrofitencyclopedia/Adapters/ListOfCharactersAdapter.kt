package com.example.retrofitencyclopedia.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitencyclopedia.R

class ListOfCharactersAdapter( private val allCharacters: List<Character>) : RecyclerView.Adapter<ListOfCharactersAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val characterName = view.findViewById<TextView>(R.id.listCharacterName)
        val characterAvatar = view.findViewById<ImageView>(R.id.listCharacterAvatar)
        val characterSpecies = view.findViewById<TextView>(R.id.listCharacterSpecies)
        val characterGender = view.findViewById<TextView>(R.id.listCharacterGender)
        val characterStatus = view.findViewById<TextView>(R.id.listCharacterStatus)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_list, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount() = allCharacters.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {





    }


}