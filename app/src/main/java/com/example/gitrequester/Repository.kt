package com.example.gitrequester

import org.intellij.lang.annotations.Language
import java.io.Serializable

data class Repository(
    val name: String,
    val description: String?,
    val language: String?
) : Serializable
