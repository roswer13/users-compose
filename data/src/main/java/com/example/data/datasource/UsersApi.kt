package com.example.data.datasource

import com.example.domain.model.ResponseData
import retrofit2.http.GET

/**
 * Interface for the Users API service.
 * This interface defines the HTTP operations for the Users API.
 */
interface UsersApi {

    /**
     * Get the list of users.
     * This is a suspend function that can be paused and resumed at a later time.
     * It uses the GET HTTP method.
     * @return a ResponseData object containing the list of users.
     */
    @GET("users")
    suspend fun getUsers(): ResponseData
}