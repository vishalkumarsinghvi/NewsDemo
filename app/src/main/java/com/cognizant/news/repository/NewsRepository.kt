package com.cognizant.news.repository

import com.cognizant.news.model.NewsArticles
import com.cognizant.news.retrofit.NewsApiService
import io.reactivex.Observable

class NewsRepository(val newsApiService: NewsApiService) {
    fun getNewsData(): Observable<NewsArticles> {
        return newsApiService.getNewsData()
    }
}