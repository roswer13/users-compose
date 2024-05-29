package com.example.userapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName(value = "page")
    val page: Int,
    @SerialName(value = "per_page")
    val perPage: Int,
    @SerialName(value = "total")
    val total: Int,
    @SerialName(value = "total_pages")
    val totalPages: Int,
    @SerialName(value = "data")
    val data: List<User>,
    @SerialName(value = "support")
    val support: Support
)
