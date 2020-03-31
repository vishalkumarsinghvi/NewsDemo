package com.cognizant.news.repository

import com.cognizant.news.model.NewsArticles
import com.cognizant.news.retrofit.NewsApiService
import retrofit2.Call

class NewsRepository(val newsApiService: NewsApiService) {
    fun getNewsData(): Call<NewsArticles> {
        return newsApiService.getNewsData()
    }
}