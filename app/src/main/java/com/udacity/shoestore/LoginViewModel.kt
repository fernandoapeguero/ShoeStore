package com.udacity.shoestore

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import timber.log.Timber

class LoginViewModel: ViewModel() {

    private var _username = MutableLiveData<String>()
    val username: LiveData<String>
        get() = _username


    private var _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password





    fun login(view: View){

        view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment2)
    }


}