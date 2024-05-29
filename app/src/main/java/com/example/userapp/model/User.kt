package com.example.userapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName(value = "id")
    val id: Int,
    @SerialName(value = "email")
    val email: String,
    @SerialName(value = "first_name")
    val firstName: String,
    @SerialName(value = "last_name")
    val lastName: String,
    @SerialName(value = "avatar")
    val avatar: String
)
