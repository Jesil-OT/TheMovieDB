package com.jesil.realproject.themoviedb.model

import com.jesil.realproject.themoviedb.retrofit.MovieNetworkDto
import com.jesil.realproject.themoviedb.util.EntityMapper
import javax.inject.Inject

class NetworkMapper @Inject constructor(

) : EntityMapper<MovieNetworkDto, MovieModel> {
    override fun mapFromEntity(entity: MovieNetworkDto): MovieModel {
        return MovieModel(
            adult = entity.adult,
            backdropPath = entity.backdropPath,
            genreIds = entity.genreIds,
            id = entity.id,
            originalLanguage = entity.originalLanguage,
            originalTitle = entity.originalTitle,
            overview = entity.overview,
            popularity = entity.popularity,
            posterPath = entity.posterPath,
            releaseDate = entity.createdReleaseDataFormatted,
            title = entity.title,
            video = entity.video,
            voteAverage = entity.voteAverage,
            voteCount = entity.voteCount
        )
    }

    override fun mapToEntity(domainModel: MovieModel): MovieNetworkDto {
        return MovieNetworkDto(
            adult = domainModel.adult,
            backdropPath = domainModel.backdropPath,
            genreIds = domainModel.genreIds,
            id = domainModel.id,
            originalLanguage = domainModel.originalLanguage,
            originalTitle = domainModel.originalTitle,
            overview = domainModel.overview,
            popularity = domainModel.popularity,
            posterPath = domainModel.posterPath,
            releaseDate = domainModel.createdReleaseDataFormatted,
            title = domainModel.title,
            video = domainModel.video,
            voteAverage = domainModel.voteAverage,
            voteCount = domainModel.voteCount
        )
    }

    fun fromEntityList(entity: List<MovieNetworkDto>): List<MovieModel> =
        entity.map { mapFromEntity(it) }

    fun toEntityList(entity: List<MovieModel>): List<MovieNetworkDto> =
        entity.map { mapToEntity(it) }
}