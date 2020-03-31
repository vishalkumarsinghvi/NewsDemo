package com.cognizant.news.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
//dao for all room query for news database
@Dao
interface NewsDao {

    @Query("SELECT * FROM newsarticles")
    fun getAllNews(): NewsArticles?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setAllNews(news: NewsArticles?)
}