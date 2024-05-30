package com.example.domain.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "user")
data class User(
    @SerializedName(value = "id") val id: Int,
    @SerializedName(value = "email") val email: String,
    @SerializedName(value = "first_name") val firstName: String,
    @SerializedName(value = "last_name") val lastName: String,
    @SerializedName(value = "avatar") val avatar: String
) : Serializable
