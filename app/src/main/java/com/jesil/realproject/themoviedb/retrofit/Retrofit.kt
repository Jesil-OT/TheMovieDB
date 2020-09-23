package com.jesil.realproject.themoviedb.retrofit

import com.google.gson.GsonBuilder
import com.jesil.realproject.themoviedb.constant.Constant
import com.jesil.realproject.themoviedb.constant.Constant.BASE_URL
import com.jesil.realproject.themoviedb.model.PopularMoviesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("movie/popular")
     fun getMovies(@Query("api_key") apiKey:String) : Call<PopularMoviesResponse>
}

val webService : RetrofitService by lazy{
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build().create(RetrofitService::class.java)
}