package com.cwong51799.practice.listing.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.cwong51799.practice.listing.Movie

class MovieDataSource(private val repository: MovieRepository) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        params.key?.let { key ->
            val response = repository.getPopularMovies(page = key)
            return LoadResult.Page(
                data = response.movies,
                prevKey = response.page,
                nextKey = response.page + 1
            )
        } ?: run {
            return LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = 1
            )
        }
    }

}