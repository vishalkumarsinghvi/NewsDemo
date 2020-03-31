package com.cognizant.news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cognizant.news.R
import com.cognizant.news.model.Rows

class NewsAdapter(private val rows: List<Rows>?) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_news_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        val mRows = rows!![position]
        holder.tvTitle.text = mRows.title
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    }

    override fun getItemCount(): Int {
        return rows?.size ?: 0
    }
}