package com.cognizant.news.utils

import android.app.Application
import android.content.Context
import com.cognizant.news.room.NewsDemoDatabase

class NewsDemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        getDb(applicationContext)

    }

    companion object {
        fun getDb(applicationContext: Context): NewsDemoDatabase {
            return NewsDemoDatabase.getINSTANCE(applicationContext)
        }
    }


}