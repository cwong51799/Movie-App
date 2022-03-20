package com.cwong51799.practice

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Core {

    private const val BASE_URL = "https://api.themoviedb.org/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

}