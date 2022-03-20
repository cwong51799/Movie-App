package com.cwong51799.practice.listing

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie(
    val adult: Boolean?,
    @Json(name="backdrop_path")
    val backdropPath: String?,
    val budget: Double?,
    val genres: List<Genre?>?,
    val homepage: String?,
    @Json(name="poster_path")
    val posterPath: String?,
    val title: String?
)

fun Movie.getUIModel() = MovieUIModel(
    title = this.title.orEmpty(),
    backdropPath = this.backdropPath,
    posterPath = this.posterPath,
    budget = this.budget ?: 0.0,
)