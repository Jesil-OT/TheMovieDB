package com.jesil.realproject.themoviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.appbar.MaterialToolbar
import com.google.gson.GsonBuilder
import com.jesil.realproject.themoviedb.constant.Constant.API_KEY
import com.jesil.realproject.themoviedb.constant.Constant.BASE_URL
import com.jesil.realproject.themoviedb.retrofit.MovieRetrofit
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {
    private lateinit var toolbar: MaterialToolbar

    private val TAG = "HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        toolbar = toolbarHomeActivity
        setSupportActionBar(toolbar)

        val service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(MovieRetrofit::class.java)

        CoroutineScope(IO).launch {
            val response = service.search(API_KEY, page = 3)

            Log.d(TAG, "onCreate: ${response.results}")

        }
    }
}