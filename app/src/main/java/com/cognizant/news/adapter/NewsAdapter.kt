package com.cognizant.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cognizant.news.R
import com.cognizant.news.model.Rows

class NewsAdapter(private val context: Context, private val rows: List<Rows>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_news_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mRows = rows[position]
        holder.tvTitle.text = mRows.title
        holder.tvDescription.text = mRows.description
        Glide.with(context).load(mRows.imageHref!!.replace("http://", "https://"))
            .placeholder(R.drawable.ic_broken).dontAnimate().into(holder.ivThumbnail)
        holder.relativeLayout.visibility = View.VISIBLE
        holder.itemView.visibility = View.VISIBLE

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val relativeLayout: RelativeLayout = itemView.findViewById(R.id.main_layout)
        val ivThumbnail: ImageView = itemView.findViewById(R.id.ivThumbnail)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDesc)
    }

    override fun getItemCount(): Int {
        return rows.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}