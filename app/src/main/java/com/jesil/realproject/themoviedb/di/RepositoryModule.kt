package com.jesil.realproject.themoviedb.di

import com.jesil.realproject.themoviedb.model.NetworkMapper
import com.jesil.realproject.themoviedb.repository.MovieRepository
import com.jesil.realproject.themoviedb.repository.MovieRepositoryImpl
import com.jesil.realproject.themoviedb.retrofit.MovieRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieService: MovieRetrofit,
        mapper: NetworkMapper
    ): MovieRepository =

        MovieRepositoryImpl(
          movieService = movieService,
          mapper = mapper
        )


}