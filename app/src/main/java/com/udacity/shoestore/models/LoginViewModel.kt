package com.udacity.shoestore.models


import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel(){

    var userList = mutableListOf<Users>()

    val _username = MutableLiveData<String>()

    val username: LiveData<String>
        get() = _username


    val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email



    val _password = MutableLiveData<String>()
    
    val password: LiveData<String>
        get() = _password


    init {
        _username.value = ""
        _email.value = ""
        _password.value = ""
    }


    fun AddUser(username: String, email: String, password: String){

    }
}