package com.example.gitrequester.viewModels

import com.example.gitrequester.data.AuthState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState
    private val repository = RepositoryAuthViewModel()


    fun onSignButtonPressed(token: String) {

        if (token.isBlank()) {
            _authState.value = AuthState.Error("Token can not be empty")
            return
        }
        _authState.value = AuthState.Loading

        viewModelScope.launch {

            val (responseCode, repositories) = repository.CheckAuthToken(token)
            // Логируем ответ в консоли
            println("Response code: $responseCode")
            println("Response message: $repositories")

            if (responseCode == 200 && repositories != null) {
                _authState.value = AuthState.Success(repositories.toTypedArray())
            } else {
                _authState.value = AuthState.Error("Invalid token")
            }
        }
    }
}