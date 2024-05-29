package com.example.userapp.network

import com.example.userapp.model.Response
import retrofit2.http.GET

/**
 * Interface for the Users API service.
 * This interface defines the HTTP operations for the Users API.
 */
interface UsersApiService {

    /**
     * Get the list of users.
     * This is a suspend function that can be paused and resumed at a later time.
     * It uses the GET HTTP method.
     * @return a Response object containing the list of users.
     */
    @GET("users")
    suspend fun getUsers(): Response
}