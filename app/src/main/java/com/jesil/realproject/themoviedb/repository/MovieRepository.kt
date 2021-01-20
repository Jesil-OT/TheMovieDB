package com.jesil.realproject.themoviedb.repository

import com.jesil.realproject.themoviedb.model.MovieModel

interface MovieRepository {

    suspend fun getMovies(api_key: String, language: String = "en-US", page: Int) : List<MovieModel>

}