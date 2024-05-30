package com.example.data.repository

import com.example.data.datasource.UsersApi
import com.example.domain.model.ResponseData
import com.example.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Implementation of the UsersRepository interface.
 *
 * This class is responsible for fetching user data from the API. It uses the UsersApi data source
 * to fetch the data and returns it as a Flow of ResponseData.
 *
 * @property usersApi The API data source for fetching user data.
 */
@Singleton
class UsersRepositoryImpl @Inject constructor(private val usersApi: UsersApi) : UsersRepository {

    /**
     * Fetches user data from the API.
     *
     * This function uses the UsersApi data source to fetch user data and returns it as a Flow of
     * ResponseData. The data is fetched when the Flow is collected.
     *
     * @return A Flow of ResponseData containing the user data fetched from the API.
     */
    override fun getUsers(): Flow<ResponseData> {
        return flow { emit(usersApi.getUsers()) }
    }
}