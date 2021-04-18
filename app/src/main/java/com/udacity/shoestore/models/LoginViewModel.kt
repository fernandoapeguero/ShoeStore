package com.udacity.shoestore.models


import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel(){


    val _username = MutableLiveData<String>()

    val username: LiveData<String>
        get() = _username


    val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email



    val _password = MutableLiveData<String>()
    
    val password: LiveData<String>
        get() = _password



}