package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.LoginViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import timber.log.Timber


class LoginFragment : Fragment() {

   private  lateinit var binding: FragmentLoginBinding
   private lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)
        viewModel = LoginViewModel()

        binding.loginViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        binding.loginButton.setOnClickListener{view: View ->

            view.requestFocus()

            binding.emailEdittext.visibility = View.GONE
            binding.loginHeadertext.text = getString(R.string.login)

            val username = binding.usernameEdittext.text
            val password = binding.passwordEdittext.text

            if(!username.isEmpty() && !password.isEmpty() ){

                view.findNavController().navigate(R.id.action_loginFragment_to_shoeListingFragment)
            }
        }

        binding.signUp.setOnClickListener{view: View ->

            view.requestFocus()

            binding.loginHeadertext.text = getString(R.string.sign_up)
            binding.emailEdittext.visibility = View.VISIBLE

            val username = binding.usernameEdittext.text
            val email = binding.emailEdittext.text
            val password = binding.passwordEdittext.text


            if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment2(username.toString()))

            }

        }

        return binding.root
    }





}