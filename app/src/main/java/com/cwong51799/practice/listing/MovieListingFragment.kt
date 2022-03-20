package com.cwong51799.practice.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cwong51799.practice.R
import com.cwong51799.practice.databinding.FragmentListingBinding
import com.cwong51799.practice.listing.pagination.MoviePagingAdapter
import kotlinx.coroutines.flow.collectLatest

class MovieListingFragment : Fragment() {

    private lateinit var viewModel: MovieListingViewModel
    private lateinit var binding: FragmentListingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieListingViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListingBinding.inflate(layoutInflater)
        binding.welcomeMessage.text = getString(
            R.string.welcome_message, arguments?.get(
                USERNAME_BUNDLE_KEY
            )
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieAdapter = MoviePagingAdapter()
        binding.listing.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.listingDataFlow.collectLatest { movieData ->
                movieAdapter.submitData(movieData)
            }
        }
    }

    companion object {
        const val USERNAME_BUNDLE_KEY = "usernameKey"
    }
}