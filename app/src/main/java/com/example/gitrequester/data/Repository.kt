package com.example.gitrequester.data

import java.io.Serializable

data class Repository(
    val name: String,
    val description: String?,
    val language: String?
) : Serializable


