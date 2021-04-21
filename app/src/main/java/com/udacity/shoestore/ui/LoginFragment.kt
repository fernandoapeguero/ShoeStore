package com.udacity.shoestore.ui

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.LoginViewModel


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

        setHasOptionsMenu(false)

        var isSigningUp = false

        binding.loginOrSignupTextview.setOnClickListener {

            if (!isSigningUp) {
                binding.emailEdittext.visibility = View.VISIBLE
                binding.emailTextview.visibility = View.VISIBLE

                binding.loginOrSignupTextview.text = getString(R.string.login)
                binding.loginHeadertext.text = getString(R.string.sign_up)
                binding.haveAccountTextview.text = getString(R.string.have_an_account_already)
                binding.loginButton.text = getString(R.string.sign_up)

                (activity as AppCompatActivity).supportActionBar?.title = "Sign Up"

                isSigningUp = true

            } else {
                binding.emailEdittext.visibility = View.GONE
                binding.emailTextview.visibility = View.GONE

                binding.loginButton.text = getString(R.string.login)
                binding.loginOrSignupTextview.text = getString(R.string.sign_up)
                binding.loginHeadertext.text = getString(R.string.login)
                binding.haveAccountTextview.text = getString(R.string.dont_have_account)

                (activity as AppCompatActivity).supportActionBar?.title = "Login"

                isSigningUp = false

            }

        }


        binding.loginButton.setOnClickListener { view: View ->

            val imm: InputMethodManager =
                requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)

            if (!isSigningUp) {
                if (viewModel.username.value.toString().isNotEmpty() && viewModel.password.value.toString().isNotEmpty()) {

                    view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment2(viewModel.username.value.toString()))
                } else {
                    Toast.makeText(context, "Please fill everything.", Toast.LENGTH_SHORT).show()
                }


            } else {

                if (viewModel.username.value.toString().isNotEmpty() && viewModel.email.value.toString().isNotEmpty() && viewModel.password.value.toString().isNotEmpty()) {
                    view.findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToWelcomeFragment2(viewModel.username.value.toString())
                    )
                } else {
                    Toast.makeText(context, "Please fill everything.", Toast.LENGTH_SHORT).show()

                }

            }

        }

        return binding.root
    }


}