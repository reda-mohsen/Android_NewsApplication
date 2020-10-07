package com.example.newsappinkotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //https://newsapi.org/v2/top-headlines?apiKey=36cae1bf876241de99f19c249d5d5211&country=us
    @GET("v2/everything")
    fun getHead (@Query("q")d:String="bitcoin",
                 @Query("apiKey")apiKey:String="36cae1bf876241de99f19c249d5d5211",
                 @Query("page")page:Int): Call<Response>
}