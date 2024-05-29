package com.example.userapp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * This is a Retrofit instance for making network requests.
 * It uses a converter factory for serialization and deserialization of objects.
 * The base URL for the API is set here.
 */
private val retrofit = Retrofit.Builder()
    // Add converter factory for serialization and deserialization of objects
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BaseURL.URL) // Set the base URL for the API
    .build()

/**
 * Singleton object for accessing the Users API.
 * It contains a lazy-initialized Retrofit service.
 */
object UsersApi {
    /**
     * Lazy-initialized Retrofit service.
     * The Retrofit service is created here.
     */
    val retrofitService: UsersApiService by lazy {
        retrofit.create(UsersApiService::class.java) // Create the Retrofit service
    }
}