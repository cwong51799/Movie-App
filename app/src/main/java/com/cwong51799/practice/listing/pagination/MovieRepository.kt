package com.cwong51799.practice.listing.pagination

import com.cwong51799.practice.listing.Movie
import com.cwong51799.practice.listing.PopularMoviesResponse

class MovieRepository(private val service: MovieService) {

    suspend fun getMovie(movieId: String): Movie {
        return service.getMovieDetails(id = movieId)
    }

    suspend fun getPopularMovies(page: Int): PopularMoviesResponse {
        return service.getPopularMovies(page = page)
    }

}