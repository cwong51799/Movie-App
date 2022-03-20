package com.cwong51799.practice.listing.pagination

import com.cwong51799.practice.listing.Movie
import com.cwong51799.practice.listing.PopularMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("/{version}/{type}/{id}")
    suspend fun getMovieDetails(
        @Path("version") version: Int = 3,
        @Path("type") type: String = "movie",
        @Path("id") id: String,
        @Query("apiKey") apiKey: String = API_KEY,
    ): Movie

    @GET("{version}/movie/popular")
    suspend fun getPopularMovies(
        @Path("version") version: Int = 3,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int
    ): PopularMoviesResponse

    companion object {
        private const val API_KEY = "01e2a1ac471c238208f2fccfa015f415"
    }
}