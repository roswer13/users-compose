package com.example.userapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Support(
    @SerialName(value = "url")
    val url: String,
    @SerialName(value = "text")
    val text: String,
)