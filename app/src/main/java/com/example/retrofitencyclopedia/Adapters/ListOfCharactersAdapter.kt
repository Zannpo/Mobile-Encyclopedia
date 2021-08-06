package com.example.retrofitencyclopedia.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitencyclopedia.Model.Character
import com.example.retrofitencyclopedia.Model.Characters
import com.example.retrofitencyclopedia.R
import com.squareup.picasso.Picasso
import kotlinx.coroutines.withContext
import java.security.AccessController.getContext

class ListOfCharactersAdapter(private val allCharacters: Characters): RecyclerView.Adapter<ListOfCharactersAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(character: Character) {
            val characterName = itemView.findViewById<TextView>(R.id.listCharacterName)
            val characterAvatar = itemView.findViewById<ImageView>(R.id.listCharacterAvatar)
            val characterSpecies = itemView.findViewById<TextView>(R.id.listCharacterSpecies)
            val characterGender = itemView.findViewById<TextView>(R.id.listCharacterGender)
            val characterStatus = itemView.findViewById<TextView>(R.id.listCharacterStatus)

            characterName.text = character.name
            characterSpecies.text = character.species
            characterGender.text = character.gender
            characterStatus.text = character.status
            Picasso.with(itemView.context).load(character.image).into(characterAvatar);

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_list, parent, false);


        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return allCharacters.results.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val character = allCharacters.results[position]
        holder?.let {
            it.bindView(character)
        }



    }


}