package com.jesil.realproject.themoviedb.retrofit

import android.text.format.DateUtils
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.text.DateFormat

// Entity data class
data class MovieNetworkDto(

    @SerializedName("adult")
    @Expose
    var adult : Boolean,

    @SerializedName("backdrop_path")
    @Expose
    var backdropPath : String,

    @SerializedName("genre_ids")
    @Expose
    var genreIds : List<Int>,

    @SerializedName("id")
    @Expose
    var id : Int,

    @SerializedName("original_language")
    @Expose
    var originalLanguage : String,

    @SerializedName("original_title")
    @Expose
    var originalTitle : String,

    @SerializedName("overview")
    @Expose
    var overview : String,

    @SerializedName("popularity")
    @Expose
    var popularity: Double,

    @SerializedName("poster_path")
    @Expose
    var posterPath : String,

    @SerializedName("release_date")
    @Expose
    var releaseDate : String = DateUtils.MONTH_DAY_FORMAT,

    @SerializedName("title")
    @Expose
    var title : String,

    @SerializedName("video")
    @Expose
    var video : Boolean,

    @SerializedName("vote_average")
    @Expose
    var voteAverage : Double,

    @SerializedName("vote_count")
    @Expose
    var voteCount : Int
){
    val createdReleaseDataFormatted : String
        get() = DateFormat.getDateInstance().format(releaseDate)
}