package com.cognizant.news.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {

    @Query("SELECT * FROM newsarticles")
    fun getAllNews(): NewsArticles?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setAllNews(news: NewsArticles?)
}