package com.jesil.realproject.themoviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.appbar.MaterialToolbar
import com.google.gson.GsonBuilder
import com.jesil.realproject.themoviedb.constant.Constant.API_KEY
import com.jesil.realproject.themoviedb.constant.Constant.BASE_URL
import com.jesil.realproject.themoviedb.retrofit.MovieRetrofit
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        toolbar = toolbarHomeActivity
        setSupportActionBar(toolbar)



    }
}