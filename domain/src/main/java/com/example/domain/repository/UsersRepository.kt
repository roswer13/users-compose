package com.example.domain.repository

import com.example.domain.model.Response
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun getUsers(): Flow<Response>
}