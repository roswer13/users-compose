package com.example.domain.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "support")
data class Response(
    @SerializedName(value = "page") val page: Int,
    @SerializedName(value = "per_page") val perPage: Int,
    @SerializedName(value = "total") val total: Int,
    @SerializedName(value = "total_pages") val totalPages: Int,
    @SerializedName(value = "data") val data: List<User>,
    @SerializedName(value = "support") val support: Support
) : Serializable