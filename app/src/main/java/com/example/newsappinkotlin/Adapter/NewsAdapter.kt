package com.example.newsappinkotlin.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappinkotlin.Model.News
import com.example.newsappinkotlin.R
import kotlinx.android.synthetic.main.card.view.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.newsappinkotlin.ui.destinations.ViewModel.MyVM


class NewsAdapter(var news:MutableList<News>,var model: MyVM): RecyclerView.Adapter<NewsAdapter.MyVH>() {
    class MyVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onbind(n:News){
            itemView.txt.text=n.title
            itemView.txt2.text=n.author
            Glide.with(itemView).load("${n.image}").transform(CenterCrop()).into(itemView.img)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH=MyVH(
        LayoutInflater.from(parent.context).inflate(R.layout.card,parent, false)
    )
    override fun getItemCount(): Int =news.size

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.onbind(news[position])
        holder.itemView.setOnClickListener(){
            model.selectArticle(news[position])
        }
    }
    fun append(list: List<News>){
        this.news.addAll(list)
        notifyItemRangeChanged(this.itemCount,news.size-1)
    }


}