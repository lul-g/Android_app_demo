package com.example.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demo.ui.CharacterDetailFragment
import com.example.demo.ui.CharacterListFragment
import org.w3c.dom.Text

class CharacterAdapter(private val characters: List<Character>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    inner class CharacterViewHolder(
        itemView: View,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ): RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.char_img)
        val characterName: TextView = itemView.findViewById(R.id.char_name)
//        val characterDescription: TextView = itemView.findViewById(R.id.char_description)
//        val characterUniverse: TextView = itemView.findViewById(R.id.char_universe)
        val characterAge: TextView = itemView.findViewById(R.id.char_age)
        val characterId: TextView = itemView.findViewById((R.id.char_id))

        init {
            //code is always gonna run
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_card_view, parent,  false)
        return CharacterViewHolder(view) {pos ->
            val character = characters[pos]
            val bundle = bundleOf(
                "name" to character.name,
                "age" to character.age,
                "img" to character.img,
                "id" to character.id,
                "universe" to character.universe,
                "description" to character.description,
            )

            val detailFragment = CharacterDetailFragment()
            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
//        holder.characterImage.setImageResource(character.img)

        Glide
            .with(holder.itemView.context)
            .load(character.img)
            .error(R.drawable.god)
            .into(holder.characterImage)
        holder.characterName.text = character.name
//        holder.characterDescription.text = character.description
//        holder.characterUniverse.text = character.universe
        holder.characterAge.text = character.age.toString()
        holder.characterId.text = character.id

    }
}