package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.constraintlayout.core.state.State
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeListViewModel
import kotlinx.android.synthetic.main.customlayout.view.*

class ShoeListingFragment : Fragment() {

    private lateinit var binding: FragmentShoeListingBinding
    private lateinit var viewModel: ShoeListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_listing, container, false)
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        setHasOptionsMenu(true)

        val data = viewModel._shoes

        for (item in data.value!!){
            val newView = inflater.inflate(R.layout.customlayout, container , false)
            newView.name.text = item.name
            newView.description.text = item.description
            newView.detail.setOnClickListener {
                seeDetail(it)
            }
            newView.shoe_image.setImageResource(R.drawable.air_jordan)

            binding.viewHolder.addView(newView)

        }

        binding.addShoe.setOnClickListener{
            addShoe()
        }

        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.log_out -> activity?.onBackPressed()
            else -> return  super.onOptionsItemSelected(item)
        }
        return true
    }

    fun addShoe(){
        val data = viewModel._shoes

        data.value?.add( Shoe(
            "Air Jordan Retro",
            10.5,
            "Nike",
            "best shoes around",
            mutableListOf(
                "air_jordan"
            )
        ))

        val shoe = data.value?.get(data.value!!.size - 1)

        val newView = LayoutInflater.from(context).inflate(R.layout.customlayout, null)
        newView.name.text = shoe?.name
        newView.description.text = shoe?.description

        newView.shoe_image.setImageResource(R.drawable.air_jordan)

        binding.viewHolder.addView(newView)
    }

    fun seeDetail(view: View){

        view.findNavController().navigate(R.id.action_shoeListingFragment_to_detailFragment)
    }
}