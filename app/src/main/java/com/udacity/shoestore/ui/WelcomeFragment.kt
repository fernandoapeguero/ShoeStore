package com.udacity.shoestore.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater,
            R.layout.fragment_welcome, container, false)

        val args = WelcomeFragmentArgs.fromBundle(requireArguments())

        binding.usernameWelcomeTextview.text = args.username

        binding.nextButton.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_welcomeFragment2_to_instructionsFragment2)
        }


        return binding.root
    }


}