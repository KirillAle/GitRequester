package com.example.gitrequester.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.security.cert.CertPathValidatorException.Reason

class AuthViewModel : ViewModel() {
   private val _state = MutableLiveData<String>()

    val state: LiveData<String> = _state

//    sealed interface State{
//        object Idle: State
//        object Loading: State
//        data class InvalidInput(val reason: String): State
//    }


    fun onSignButtonPressed(token: String) {
//        if(token.isBlank()) {
//            _state.value = State.InvalidInput("Token can not be empty")
//            return
//        }
//        _state.value = State.Loading



    }
}