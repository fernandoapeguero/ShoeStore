package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.models.ShoeListViewModel
import kotlinx.android.synthetic.main.customlayout.view.*


class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoeListingBinding
    private val viewModel: ShoeListViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_shoe_listing,
            container,
            false
        )

        setHasOptionsMenu(true)

        val data = viewModel._shoes

        if (!data.value.isNullOrEmpty()) {
            for (item in data.value!!) {
                val newView = inflater.inflate(R.layout.customlayout, container, false)
                newView.name.text = item.name
                newView.description.text = item.description
                newView.detail.setOnClickListener { view: View ->
                    seeDetail(view)
                }
                newView.shoe_image.setImageResource(R.drawable.air_jordan)

                binding.viewHolder.addView(newView)

            }

        }

        binding.addShoe.setOnClickListener { view: View ->
            addShoe(view)
        }

        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.log_out -> activity?.onBackPressed()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    fun addShoe(view: View) {

        view.findNavController().navigate(R.id.action_shoeListingFragment_to_addShoeFragment)
    }

    fun seeDetail(view: View) {
        view.findNavController().navigate(R.id.action_shoeListingFragment_to_detailFragment)
    }
}