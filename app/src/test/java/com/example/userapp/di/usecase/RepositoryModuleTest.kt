package com.example.userapp.di.usecase

import com.example.data.datasource.UsersApi
import com.example.data.repository.UsersRepositoryImpl
import com.example.domain.repository.UsersRepository
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito

class RepositoryModuleTest {
    @Test
    fun `providesUsersUseCase returns UsersRepository`() {
        val usersApi = Mockito.mock(UsersApi::class.java)
        val usersRepository = RepositoryModule().provideUsersUseCase(usersApi)
        assertTrue(usersRepository is UsersRepository)
    }

    @Test
    fun `providesUsersUseCase returns UsersRepositoryImpl`() {
        val usersApi = Mockito.mock(UsersApi::class.java)
        val usersRepository = RepositoryModule().provideUsersUseCase(usersApi)
        assertTrue(usersRepository is UsersRepositoryImpl)
    }
}