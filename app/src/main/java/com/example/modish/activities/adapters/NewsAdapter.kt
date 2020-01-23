package com.example.modish.activities.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater
import android.content.Context
import com.example.modish.R
import com.example.modish.activities.models.NewsModel

class NewsAdapter(private var news: ArrayList<NewsModel>, private var mContext: Context?) : RecyclerView.Adapter<NewsAdapter.ViewHolde>() {

    override fun onBindViewHolder(viewHolder: ViewHolde, position: Int) {

        viewHolder.newsTitle.setText(news.get(position).newsTitle)
        //viewHolder.newsDetails.setText(news.get(position).newsDetails)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): NewsAdapter.ViewHolde {
        val view = LayoutInflater.from(viewGroup.context).inflate(com.example.modish.R.layout.custom_latest_news, viewGroup, false)
        return NewsAdapter.ViewHolde(view)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    class ViewHolde : RecyclerView.ViewHolder {

        var newsTitle : TextView
        var newsDetails : TextView
        var newsImg : ImageView

        constructor(itemView : View) : super(itemView) {
            newsTitle = itemView.findViewById(R.id.tv_news_title)
            newsDetails = itemView.findViewById(R.id.tv_news_details)
            newsImg = itemView.findViewById(R.id.img_latest_news)
        }
    }
}
