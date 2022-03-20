package com.cwong51799.practice.listing

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PopularMoviesResponse(
    val page: Int,
    @Json(name = "results")
    val movies: List<Movie>)