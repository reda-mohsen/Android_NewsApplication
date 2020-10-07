package com.example.newsappinkotlin.ui.destinations.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsappinkotlin.Model.News
import com.example.newsappinkotlin.Network.Repo
import com.example.newsappinkotlin.Model.Response
import retrofit2.Call
import retrofit2.Callback

class MyVM : ViewModel() {
    var newsLiveData: MutableLiveData<News> = MutableLiveData()
    var newsLiveData2: MutableLiveData<News> = MutableLiveData()
    var newsLD: MutableLiveData<News> = MutableLiveData()
    var mutNewsLiveData: MutableLiveData<List<News>> = MutableLiveData()

    fun selectArticle(it : News){
        newsLiveData.postValue(it)
    }
    fun getnld(){
        newsLD=newsLiveData2
    }
    fun festchN (page:Int) {
        Repo.Ser.getHead(page = page).enqueue(object : Callback<Response> {
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("Tag failed to connect", "Response: Failed")
            }
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                Log.d("Tag Response of API ", "Response:${response.body()!!.news}")
                mutNewsLiveData.postValue(response.body()!!.news)
            }
        })
    }
}