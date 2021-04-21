package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeListViewModel

class AddShoeFragment : Fragment() {

    private lateinit var binding: FragmentAddShoeBinding
//    private lateinit var viewModel: ShoeListViewModel

    private val viewModel: ShoeListViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_add_shoe, container, false)

        binding.submitShoe.setOnClickListener{ view: View ->
            viewModel.addShoe()

            activity?.onBackPressed()
        }

        binding.cancelSubmittion.setOnClickListener {
            viewModel.reset_variables()

            activity?.onBackPressed()
        }
        binding.addShoeViewModel = viewModel

        return binding.root
    }

}