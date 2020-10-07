package com.example.newsappinkotlin.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repo {

    //https://newsapi.org/v2/top-headlines?apiKey=36cae1bf876241de99f19c249d5d5211&country=us
    val bUrl:String="https://newsapi.org/"
    val Ser: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(bUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        Ser = retrofit.create(
            ApiService::class.java)
    }
}