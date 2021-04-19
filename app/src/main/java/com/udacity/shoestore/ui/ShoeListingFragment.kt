package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.setPadding
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeList
import kotlinx.android.synthetic.main.customlayout.view.*
import kotlinx.android.synthetic.main.fragment_welcome.*

class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoeListingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_listing, container, false)

        var shoes = ShoeList()

        val newView = inflater.inflate(R.layout.customlayout, container , false)
        newView.name.text = shoes.shoes[1].name

        newView.shoe_image.setImageResource(R.drawable.air_jordan)

        binding.viewHolder.addView(newView)


        return binding.root

    }

}