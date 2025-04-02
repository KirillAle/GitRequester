package com.example.gitrequester.viewModels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _state = MutableLiveData<String>()
    val state: LiveData<String> = _state
    private val repository = RepositoryAuthViewModel()



    fun onSignButtonPressed(token: String) {

        if (token.isBlank()) {
            _state.value = "Token can not be empty"
            return
        }
        _state.value = "Loading..."

        viewModelScope.launch {
            try {
                val (responseCode,response) = repository.CheckAuthToken(token)
                // Логируем ответ в консоли
                println("Response code: $responseCode")
                println("Response message: $response")

                if (responseCode == 200) {
                    _state.value = "Success: $response"
                } else {
                    _state.value = "Invalid token: $responseCode\n$response"
                }
            } catch (e: Exception) {
                _state.value = "Error: ${e.message}"
            }
        }
    }
}