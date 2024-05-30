package com.example.domain.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "support")
data class Support(
    @SerializedName(value = "url") val url: String,
    @SerializedName(value = "text") val text: String,
) : Serializable