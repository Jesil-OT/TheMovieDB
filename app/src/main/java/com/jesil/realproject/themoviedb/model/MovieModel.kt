package com.jesil.realproject.themoviedb.model

import android.text.format.DateUtils
import java.text.DateFormat

// domain model data class

data class MovieModel (
    var adult : Boolean,
    var backdropPath : String,
    var genreIds : List<Int>,
    var id : Int,
    var originalLanguage : String,
    var originalTitle : String,
    var overview : String,
    var popularity: Double,
    var posterPath : String,
    var releaseDate : String = DateUtils.MONTH_DAY_FORMAT,
    var title : String,
    var video : Boolean,
    var voteAverage : Double,
    var voteCount : Int

) {
    val createdReleaseDataFormatted : String
        get() = DateFormat.getDateInstance().format(releaseDate)
}