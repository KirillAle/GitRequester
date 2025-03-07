package com.example.gitrequester.viewModels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitrequester.data.AuthApiService
import kotlinx.coroutines.launch
import java.security.cert.CertPathValidatorException.Reason

class AuthViewModel : ViewModel() {
    private val _state = MutableLiveData<String>()
    val state: LiveData<String> = _state
    private val repository = RepositoryAuthViewModel()


    fun onSignButtonPressed(token: String, context: Context) {

        if (token.isBlank()) {
            _state.value = "Token can not be empty"
            Toast.makeText(context, "Token can not be empty", Toast.LENGTH_LONG).show()
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
                    Toast.makeText(
                        context,
                        "Success: $response",
                        Toast.LENGTH_LONG
                    ).show()

                } else _state.value = "Invalid token: $responseCode\n$response"
                Toast.makeText(
                    context,
                    "Invalid token: $responseCode\n$response",
                    Toast.LENGTH_LONG
                ).show()

            } catch (e: Exception) {
                _state.value = "Error: ${e.message}"
                Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

}