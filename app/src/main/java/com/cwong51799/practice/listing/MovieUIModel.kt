package com.cwong51799.practice.listing

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class MovieUIModel(
    val title: String,
    val backdropPath: String?,
    val posterPath: String?,
    val budget: Double
) {

    companion object {

        private const val IMAGE_HOST = "https://image.tmdb.org/t/p/w500"

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, path: String?) {
            Glide.with(view.context).load(IMAGE_HOST + path).into(view)
        }
    }

}