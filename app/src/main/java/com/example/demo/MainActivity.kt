package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random


/**
 * HW
 * MORE DATA IN DISPLAY
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.character_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val characters = mutableListOf<Character>()

        for(i in 0 .. 30) {
            characters.add(createCharacter(i))
        }
        val adapter = CharacterAdapter(characters)
        recyclerView.adapter = adapter
    }

    private fun createCharacter(i: Int) = Character(
        "Name",
        Random.nextInt(10, 99),
        R.drawable.god,
        "Earth",
        if (i <=9)  "0$i" else i.toString(),
        listOf()
    )



}