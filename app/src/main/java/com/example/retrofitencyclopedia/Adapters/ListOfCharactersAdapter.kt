package com.example.retrofitencyclopedia.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitencyclopedia.Model.Character
import com.example.retrofitencyclopedia.R

class ListOfCharactersAdapter(private var allCharacters:List<Character?>) : RecyclerView.Adapter<ListOfCharactersAdapter.ViewHolder>() {
    //private var allCharacters: List<Character>
    //private var allCharacters = emptyList<Character>()



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val characterName = view.findViewById<TextView>(R.id.listCharacterName)
        val characterAvatar = view.findViewById<ImageView>(R.id.listCharacterAvatar)
        val characterSpecies = view.findViewById<TextView>(R.id.listCharacterSpecies)
        val characterGender = view.findViewById<TextView>(R.id.listCharacterGender)
        val characterStatus = view.findViewById<TextView>(R.id.listCharacterStatus)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_item_list, parent, false);


        return ViewHolder(view)
    }

    override fun getItemCount() = allCharacters.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.characterName.text = allCharacters[position]?.name.toString()
        holder.characterStatus.text = allCharacters[position]?.status.toString()
        holder.characterSpecies.text = allCharacters[position]?.species.toString()
        holder.characterGender.text = allCharacters[position]?.gender.toString()



    }

/*
    fun setData(newList: List<Character>){
        allCharacters = newList
        notifyDataSetChanged()
    }*/
}