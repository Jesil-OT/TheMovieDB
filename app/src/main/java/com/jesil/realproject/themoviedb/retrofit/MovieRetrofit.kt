package com.jesil.realproject.themoviedb.retrofit

import com.jesil.realproject.themoviedb.response.MovieSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieRetrofit {

    @GET("movie/popular")
    suspend fun getMovies(
        @Query("api_key") api_key : String,
        @Query("language") language : String = "en-US",
        @Query("page") page : Int
    ): MovieSearchResponse

}