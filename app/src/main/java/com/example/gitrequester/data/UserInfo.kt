package com.example.gitrequester.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    @SerialName("login") val login: String,
    @SerialName("id") val id: Int

)
