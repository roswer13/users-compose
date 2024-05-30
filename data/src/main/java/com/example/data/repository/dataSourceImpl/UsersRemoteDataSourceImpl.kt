package com.example.data.repository.dataSourceImpl

import com.example.data.api.UsersApi
import com.example.data.repository.dataSource.UsersRemoteDataSource
import com.example.domain.model.ResponseData
import kotlinx.coroutines.flow.Flow

class UsersRemoteDataSourceImpl(private val usersApi: UsersApi) : UsersRemoteDataSource {
    override fun getUsers(): Flow<ResponseData> {
        TODO("Not yet implemented")
    }

}