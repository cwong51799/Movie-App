package com.cwong51799.practice.listing

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.cwong51799.practice.Core
import com.cwong51799.practice.listing.pagination.MovieDataSource
import com.cwong51799.practice.listing.pagination.MovieRepository
import com.cwong51799.practice.listing.pagination.MovieService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieListingViewModel : ViewModel() {

    private val repository = MovieRepository(Core.retrofit.create(MovieService::class.java))

    var listingDataFlow: Flow<PagingData<MovieUIModel>> = getPagerFlow()

    private fun getPagerFlow() = Pager(
        PagingConfig(
            pageSize = PAGE_SIZE,
            initialLoadSize = PAGE_SIZE
        )
    ) {
        buildPagingSource()
    }.flow.map { pagingData ->
        pagingData.map { listEntry -> listEntry.getUIModel() }
    }

    private fun buildPagingSource() = MovieDataSource(repository)

    companion object {
        private const val PAGE_SIZE = 10
    }
}