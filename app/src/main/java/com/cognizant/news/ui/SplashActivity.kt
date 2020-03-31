package com.cognizant.news.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cognizant.news.R
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        init()
    }

    private fun init() {
        Handler().postDelayed({ openNewsActivity() }, 1000)
    }

    private fun openNewsActivity() {
        startActivity(Intent(this@SplashActivity, NewsActivity::class.java))
        finish()
    }


}
