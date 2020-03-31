package com.cognizant.news.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.cognizant.news.R
import com.cognizant.news.adapter.NewsAdapter
import com.cognizant.news.model.NewsArticles
import com.cognizant.news.model.NewsDao
import com.cognizant.news.repository.NewsRepository
import com.cognizant.news.retrofit.NewsApiService
import com.cognizant.news.utils.NetworkUtils
import com.cognizant.news.utils.NewsDemoApplication.Companion.getDb
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    private var mNewsAdapter: NewsAdapter? = null
    private lateinit var newsDao: NewsDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        //init dao instance for local data if internet is not there
        newsDao = getDb(applicationContext = this).NewsDao()
        getNewsData()
        swipeToRefresh.setOnRefreshListener { getNewsData() }

    }

    //fetch latest news data from api
    private fun getNewsData() {
        swipeToRefresh.isRefreshing = false
        showProgress()
        if (NetworkUtils.isNetworkAvailable(this)) {
            NewsRepository(newsApiService = NewsApiService.create()).getNewsData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    prepareRecyclerView(result)
                    newsDao.setAllNews(result)
                    hideProgress()
                },
                    { error ->
                        error.printStackTrace()
                        prepareRecyclerView(newsDao.getAllNews())
                        hideProgress()
                    })
            hideInternetError()
        } else {
            prepareRecyclerView(newsDao.getAllNews())
            tvMessage.text = getString(R.string.internet_error)
            hideProgress()
            showInternetError()
        }
    }

    private fun prepareRecyclerView(newsArticles: NewsArticles?) {
        if (newsArticles?.title != null) {
            supportActionBar!!.title = newsArticles.title
        }
        mNewsAdapter = NewsAdapter(newsArticles?.rows)
        newsRecyclerView.layoutManager = LinearLayoutManager(this)
        newsRecyclerView.itemAnimator = DefaultItemAnimator()
        newsRecyclerView.adapter = mNewsAdapter

    }

    //hide progress bar
    private fun showProgress() {
        progress_Bar.visibility = View.VISIBLE
    }

    //hide progress bar
    private fun hideProgress() {
        progress_Bar.visibility = View.GONE
    }

    //show internet error
    private fun showInternetError() {
        tvMessage.visibility = View.VISIBLE
    }

    //hide internet error
    private fun hideInternetError() {
        tvMessage.visibility = View.GONE
    }


}

