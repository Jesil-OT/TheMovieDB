package com.jesil.realproject.themoviedb.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jesil.realproject.themoviedb.constant.Constant.BASE_URL
import com.jesil.realproject.themoviedb.retrofit.MovieRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideGson() : Gson =
         GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()

    @Provides
    @Singleton
    fun provideRetrofit(gson : Gson) : Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))

    fun provideMovieRetrofit(retrofit: Retrofit.Builder): MovieRetrofit =
        retrofit
            .build()
            .create(MovieRetrofit::class.java)
}