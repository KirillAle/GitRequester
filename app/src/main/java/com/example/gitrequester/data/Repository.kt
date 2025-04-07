package com.example.gitrequester.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import java.io.Serializable

@Parcelize
@kotlinx.serialization.Serializable
data class Repository(
    val name: String,
    val description: String? = null,
    val language: String? = null,
    @SerialName("html_url") val htmlUrl: String,
) : Parcelable
