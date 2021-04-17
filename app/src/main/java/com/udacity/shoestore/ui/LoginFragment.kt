package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.LoginViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
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


        var isSigningUp = false

        binding.loginOrSignupTextview.setOnClickListener { view: View ->

            if (!isSigningUp) {
                binding.emailEdittext.visibility = View.VISIBLE
                binding.emailTextview.visibility = View.VISIBLE

                binding.loginOrSignupTextview.text = getString(R.string.login)
                binding.loginHeadertext.text = getString(R.string.sign_up_upper)
                binding.haveAccountTextview.text = getString(R.string.have_an_account_already)
                binding.loginButton.text = getString(R.string.sign_up_upper)
                isSigningUp = true

            } else {
                binding.emailEdittext.visibility = View.GONE
                binding.emailTextview.visibility = View.GONE

                binding.loginButton.text = getString(R.string.login_upper)
                binding.loginOrSignupTextview.text = getString(R.string.sign_up)
                binding.loginHeadertext.text = getString(R.string.login_upper)
                binding.haveAccountTextview.text = getString(R.string.dont_have_account)
                isSigningUp = false

            }

        }

        binding.loginButton.setOnClickListener { view: View ->

            val username = binding.usernameEdittext.text
            val password = binding.passwordEdittext.text
            if (!isSigningUp) {
                if (username.isNotEmpty() && password.isNotEmpty()) {

                    view.findNavController()
                        .navigate(R.id.action_loginFragment_to_shoeListingFragment)
                }
            } else {

                val username = binding.usernameEdittext.text
                val email = binding.emailEdittext.text
                val password = binding.passwordEdittext.text

                if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                    view.findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToWelcomeFragment2(username.toString())
                    )

                }
            }

        }


//        binding.signUp.setOnClickListener{view: View ->
//
//            view.requestFocus()
//
//            binding.loginHeadertext.text = getString(R.string.sign_up)
//            binding.emailEdittext.visibility = View.VISIBLE
//            binding.emailTextview.visibility= View.VISIBLE
//
//            val username = binding.usernameEdittext.text
//            val email = binding.emailEdittext.text
//            val password = binding.passwordEdittext.text
//
//
//            if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
//                view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment2(username.toString()))
//
//            }

//        }

        return binding.root
    }


}