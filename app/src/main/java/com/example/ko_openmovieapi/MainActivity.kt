package com.example.ko_openmovieapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.example.ko_openmovieapi.databinding.ActivityMainBinding
import com.google.gson.Gson
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://kobis.or.kr/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val retrofitService = retrofit.create(MovieRetrofitService::class.java)

            retrofitService.movieData().enqueue(object : Callback<MovieRank>{
                override fun onResponse(call: Call<MovieRank>, response: Response<MovieRank>) {
                    Toast.makeText(this@MainActivity, "레트로핏 시작", Toast.LENGTH_SHORT).show()
                    val movieResponse: MovieRank? = response.body()
                    val items: MutableList<MovieItem> = mutableListOf()
                    items.addAll(movieResponse?.boxOfficeResult?.dailyBoxOfficeList!!)
                    binding.recyclerview.adapter=MyAdapter(this@MainActivity,items)

                }

                override fun onFailure(call: Call<MovieRank>, t: Throwable) {
                    Log.d("JJJ","${t.message}")
                }

            })
        }



    }
}