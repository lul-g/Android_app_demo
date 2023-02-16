package com.example.demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.*
import kotlin.random.Random


class CharacterListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_character_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.char_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val characters = mutableListOf<com.example.demo.Character>()

//        val activity: MainActivity? = activity as MainActivity?
//        val data: MutableList<List<com.example.demo.Result>> = activity!!.passData()

        for(i in 0 .. 30) {
            characters.add(createCharacter(i))
        }

        val adapter = CharacterAdapter(characters)
        recyclerView.adapter = adapter

        return view
    }
    private fun createCharacter(i: Int) = Character(
        "Rick Sanchez",
        Random.nextInt(10, 99),
        "https://rickandmortyapi.com/api/character/avatar/${i}.jpeg",
        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero enim praesentium id nulla" +
                " neque odit velit error reprehenderit nostrum officiis illum nemo, quae fugiat. Quis porro " +
                "inventore quisquam! Sapiente, ea.",
        "EARTH C-96",
        if (i <=9)  "0$i" else i.toString(),
        listOf()
    )
}