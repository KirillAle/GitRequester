package com.example.gitrequester.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    val token = MutableLiveData<String>()
}