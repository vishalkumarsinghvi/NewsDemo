package com.cognizant.news.retrofit

import com.cognizant.news.model.NewsArticles
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface NewsApiService {

    //GET query for news data
    @GET("facts.json")
    fun getNewsData(): Call<NewsArticles>

    //static class single instance
    companion object Factory {
        fun create(): NewsApiService {
            val retrofit: Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/")
                .build()
            return retrofit.create(NewsApiService::class.java)
        }
    }
}