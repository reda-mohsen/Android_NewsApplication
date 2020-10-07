package com.example.newsappinkotlin

import com.google.gson.annotations.SerializedName

class Response (
    @SerializedName("articles") var news: MutableList<News>,
    @SerializedName("status") var status: String,
    @SerializedName("totalResults") var p : Int
)