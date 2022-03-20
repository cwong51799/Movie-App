package com.cwong51799.practice.listing.pagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cwong51799.practice.databinding.MovieItemBinding
import com.cwong51799.practice.listing.MovieUIModel

class MoviePagingAdapter :
    PagingDataAdapter<MovieUIModel, MoviePagingAdapter.MovieViewHolder>(MovieComparator) {

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    object MovieComparator : DiffUtil.ItemCallback<MovieUIModel>() {
        override fun areItemsTheSame(oldItem: MovieUIModel, newItem: MovieUIModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: MovieUIModel, newItem: MovieUIModel): Boolean {
            return oldItem.title == newItem.title
        }
    }

    inner class MovieViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(entry: MovieUIModel) = with(binding) {
            movie = entry
        }

    }
}
