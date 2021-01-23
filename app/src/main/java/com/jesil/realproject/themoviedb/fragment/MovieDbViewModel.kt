package com.jesil.realproject.themoviedb.fragment

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesil.realproject.themoviedb.constant.Constant.TAG
import com.jesil.realproject.themoviedb.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieDbViewModel @ViewModelInject constructor(
    private val apiKey : String,
    private val movieRepository: MovieRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            Log.d(TAG, ": ${movieRepository.getMovies(apiKey, page = 1)}")
        }
    }

}