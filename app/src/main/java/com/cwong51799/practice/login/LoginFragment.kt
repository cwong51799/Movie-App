package com.cwong51799.practice.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cwong51799.practice.R
import com.cwong51799.practice.databinding.FragmentLoginBinding
import com.cwong51799.practice.listing.MovieListingFragment

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.liveEvent.observe(viewLifecycleOwner) { event ->
            when (event) {
                is LoginViewModel.LoginEvent.NavigateAfterSuccess -> {
                    navigateFromSuccessfulLogin(event.username)
                }
            }
        }

        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener {
            viewModel.handleLogin(
                binding.usernameEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }
    }

    private fun navigateFromSuccessfulLogin(username: String) {
        findNavController().navigate(
            R.id.action_loginFragment_to_listingFragment,
            bundleOf(MovieListingFragment.USERNAME_BUNDLE_KEY to username)
        )
    }

}