package com.jesil.realproject.themoviedb.repository

import com.jesil.realproject.themoviedb.model.MovieModel
import com.jesil.realproject.themoviedb.model.NetworkMapper
import com.jesil.realproject.themoviedb.retrofit.MovieRetrofit

class MovieRepositoryImpl(
    private val movieService: MovieRetrofit,
    private val mapper: NetworkMapper
) : MovieRepository {

    override suspend fun getMovies(
        api_key: String,
        language: String,
        page: Int
    ): List<MovieModel> {

        val result = movieService.getMovies(api_key, language, page).results
        return mapper.fromEntityList(result)

    }

}