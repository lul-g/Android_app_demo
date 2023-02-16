package com.example.demo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.demo.R


class CharacterDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_character_detail, container, false)
        if(arguments != null) {
            val name = requireArguments().getString("name")
            val age = requireArguments().getInt("age")
            val img = requireArguments().getString("img")
            val id = requireArguments().getString("id")
            val description = requireArguments().getString("description")
            val universe = requireArguments().getString("universe")


            view.findViewById<TextView>(R.id.char_id).text = id
            view.findViewById<TextView>(R.id.char_name).text = name
            view.findViewById<TextView>(R.id.char_age).text = age.toString()
//            view.findViewById<TextView>(R.id.char_description).text = description
//            view.findViewById<TextView>(R.id.char_universe).text = universe

            Glide.with(this)
                .load(img)
                .error(R.drawable.god)
                .into(view.findViewById<ImageView>(R.id.char_img))
        }
        return view
    }

}