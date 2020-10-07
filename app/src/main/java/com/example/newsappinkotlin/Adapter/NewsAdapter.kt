package com.example.newsappinkotlin.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappinkotlin.Model.News
import com.example.newsappinkotlin.R

class NewsAdapter (var news:MutableList<News>): RecyclerView.Adapter<NewsAdapter.MyVH>() {
    class MyVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onbind(n: News){
            //itemView.txt.text=(title)
            //itemView.txt2.text=(url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH =
        MyVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card,
                parent,
                false
            )
        )

    override fun getItemCount(): Int =news.size

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.onbind(news[position])
    }

    public fun append(list: List<News>){
        this.news.addAll(list)
        notifyItemRangeChanged(this.itemCount,news.size-1)
    }


}