package com.jesil.realproject.themoviedb.response

import com.google.gson.annotations.SerializedName
import com.jesil.realproject.themoviedb.retrofit.MovieNetworkDto

data class MovieSearchResponse(

    @SerializedName("page")
    var page : Int,

    @SerializedName("results")
    var results : List<MovieNetworkDto>,

    @SerializedName("total_pages")
    var totalPages : Int,

    @SerializedName("total_results")
    var totalResults : Int
)