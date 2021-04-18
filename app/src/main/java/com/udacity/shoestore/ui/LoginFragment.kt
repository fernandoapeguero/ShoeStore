package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.models.LoginViewModel
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
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.lifecycleOwner = this

        binding.loginViewModel = viewModel

        var isSigningUp = false

        binding.loginOrSignupTextview.setOnClickListener {

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

            if (!isSigningUp) {
                if (viewModel.username.toString().isNotEmpty() && viewModel.password.toString().isNotEmpty()) {

                    view.findNavController()
                        .navigate(R.id.action_loginFragment_to_shoeListingFragment)
                }
            } else {

                if (viewModel.username.toString().isNotEmpty() && viewModel.email.toString().isNotEmpty() && viewModel.password.toString().isNotEmpty()) {
                    view.findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToWelcomeFragment2(viewModel.username.value.toString())
                    )
                }
            }

        }

        return binding.root
    }


}