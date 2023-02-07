package com.example.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class CharacterAdapter(private val characters: List<Character>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.char_img)
        val characterName: TextView = itemView.findViewById(R.id.char_name)
        val characterAge: TextView = itemView.findViewById(R.id.char_age)
        val characterId: TextView = itemView.findViewById((R.id.char_id))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_card_view, parent,  false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.characterImage.setImageResource(character.img)
        holder.characterName.text = character.name
        holder.characterAge.text = character.age.toString()
        holder.characterId.text = character.id.toString()
    }
}