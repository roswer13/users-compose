package com.example.data.repository

import com.example.data.repository.dataSource.UsersRemoteDataSource
import com.example.domain.model.ResponseData
import com.example.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow

class UsersRepositoryImpl(
    private val usersRemoteDataSource: UsersRemoteDataSource
) : UsersRepository {
    override fun getUsers(): Flow<ResponseData> = usersRemoteDataSource.getUsers()
}