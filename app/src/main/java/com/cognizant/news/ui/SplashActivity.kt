package com.cognizant.news.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.cognizant.news.R


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        init()
    }

    //show splash so we are adding some delay here
    private fun init() {
        Handler().postDelayed({ openNewsActivity() }, 1000)
    }

    private fun openNewsActivity() {
        startActivity(Intent(this@SplashActivity, NewsActivity::class.java))
        finish()
    }


}
