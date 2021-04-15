package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
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
            binding.emailEdittext.visibility = View.GONE

            val username = binding.usernameEdittext.text
//            val email = binding.emailEdittext.text
//            val password = binding.passwordEdittext.text

            if(!username.isEmpty()){
                view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment2)

            }
        }

        binding.signUp.setOnClickListener{
            binding.emailEdittext.visibility = View.VISIBLE
        }

        return binding.root
    }





}