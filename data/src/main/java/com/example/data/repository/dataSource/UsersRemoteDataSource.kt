package com.example.data.repository.dataSource

import com.example.domain.model.ResponseData
import kotlinx.coroutines.flow.Flow

interface UsersRemoteDataSource {
    fun getUsers(): Flow<ResponseData>
}