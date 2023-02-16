package com.example.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.demo.ui.CharacterListFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
//    val BASE_URL = "https://rickandmortyapi.com/api/character/"
//    val data : MutableList<List<com.example.demo.Result>> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.activity_main)
//        getCharData()

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragment_container_view, CharacterListFragment())
            addToBackStack(null)
        }
//
    }

//    private fun getCharData() {
//        val retrofitBuilder = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BASE_URL)
//            .build()
//            .create(ApiInterface::class.java)
//
//        val retrofitData = retrofitBuilder.getData()
//
//        retrofitData.enqueue(object : Callback<List<CharacterData>?> {
//            override fun onResponse(
//                call: Call<List<CharacterData>?>,
//                response: Response<List<CharacterData>?>
//            ) {
//                val responseBody = response.body()!!
//
//                for (res in responseBody) {
//                    data.add(res.results)
//                }
//
//            }
//
//            override fun onFailure(call: Call<List<CharacterData>?>, t: Throwable) {
//                Log.d("MainActivity", "onFailure: " + t.message)
//            }
//        })
//    }
//
//    fun passData(): MutableList<List<com.example.demo.Result>> {
//        return data
//    }

}