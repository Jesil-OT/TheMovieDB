package com.jesil.realproject.themoviedb.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jesil.realproject.themoviedb.constant.Constant.API_KEY
import com.jesil.realproject.themoviedb.model.PopularMoviesResponse
import com.jesil.realproject.themoviedb.retrofit.RetrofitService
import com.jesil.realproject.themoviedb.retrofit.webService
import com.jesil.realproject.themoviedb.util.DataResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MovieDbViewModel : ViewModel() {

    private val _dataResult = MutableLiveData<DataResult<PopularMoviesResponse>>()
    val dataResult: LiveData<DataResult<PopularMoviesResponse>>
        get() = _dataResult

    private fun getMoviesFromViewModel() {
        _dataResult.postValue(DataResult.Loading())
        webService.getMovies(API_KEY).enqueue(object : Callback<PopularMoviesResponse?> {
            override fun onResponse(
                call: Call<PopularMoviesResponse?>,
                response: Response<PopularMoviesResponse?>
            ) {
                _dataResult.postValue(DataResult.Success(response.body()))
            }

            override fun onFailure(call: Call<PopularMoviesResponse?>, t: Throwable) {
                _dataResult.postValue(DataResult.Error(t))
            }
        })
    }

    init {
        getMoviesFromViewModel()
    }


    override fun onCleared() {
        super.onCleared()
        TODO("method will be used soon")
    }
}