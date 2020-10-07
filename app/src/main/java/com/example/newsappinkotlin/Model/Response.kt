package com.example.newsappinkotlin.Model

import com.example.newsappinkotlin.Model.News
import com.google.gson.annotations.SerializedName

class Response (
    @SerializedName("articles") var news: MutableList<News>,
    @SerializedName("status") var status: String,
    @SerializedName("totalResults") var p : Int
)