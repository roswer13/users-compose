package com.example.domain.repository

import com.example.domain.model.ResponseData
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun getUsers(): Flow<ResponseData>
}