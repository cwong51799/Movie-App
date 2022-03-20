package com.cwong51799.practice.listing

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Genre(val id: Int, val name: String)