package com.jesil.realproject.themoviedb

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Pair
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.jesil.realproject.themoviedb.constant.Constant
import com.jesil.realproject.themoviedb.constant.Constant.SPLASH_SCREEN
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var fadeIn : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        imageViewSplashScreen?.animation = fadeIn
        splashScreen()

    }

   private fun splashScreen(){
        Handler().postDelayed({
            val intent = Intent(this,HomeActivity::class.java)
            val pairs = Pair<View,String>(imageViewSplashScreen, getString(R.string.logo_image_splash))
            val options = ActivityOptions.makeSceneTransitionAnimation(this,pairs)
            startActivity(intent, options.toBundle())
            finish()
        },SPLASH_SCREEN.toLong())
    }


}