package com.cognizant.news.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cognizant.news.model.NewsArticles
import com.cognizant.news.model.NewsDao

@Database(entities = [NewsArticles::class], exportSchema = false, version = 1)
abstract class NewsDemoDatabase : RoomDatabase() {

    companion object {
        fun getINSTANCE(context: Context): NewsDemoDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                NewsDemoDatabase::class.java, "news-demo"
            ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        }
    }

    abstract fun NewsDao(): NewsDao
}