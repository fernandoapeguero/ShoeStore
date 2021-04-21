package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {


    var _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    val _shoeName = MutableLiveData<String>()
    val _shoeSize = MutableLiveData<String>()
    val _shoeCompany = MutableLiveData<String>()
    val _shoeDescription = MutableLiveData<String>()


    fun addShoe() {

        if(_shoeName.value.toString().isNotEmpty() && _shoeCompany.value.toString().isNotEmpty() && _shoeDescription.value.toString().isNotEmpty() && _shoeSize.value.toString().isNotEmpty()) {
             _shoes.value?.add(Shoe(
                _shoeName.value.toString(),
                _shoeSize.value.toString().toDouble(),
                _shoeCompany.value.toString(),
                _shoeDescription.value.toString()
            ))

            reset_variables()

        }
    }


    fun cancelSubmittion() {

        reset_variables()
    }


    fun reset_variables() {

        _shoeName.value = ""
        _shoeCompany.value=""
        _shoeSize.value = ""
        _shoeDescription.value = ""
    }
}