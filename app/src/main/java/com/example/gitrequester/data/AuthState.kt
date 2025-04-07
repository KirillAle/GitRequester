package com.example.gitrequester.data

sealed class AuthState {
    object Loading : AuthState()
    data class Success(val repositories: Array<Repository>) : AuthState()
    data class Error(val message: String) : AuthState()
}