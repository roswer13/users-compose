package com.example.userapp.di.usecase

import com.example.domain.repository.UsersRepository
import com.example.domain.useCase.GetUsersUseCase
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito

class UsersUseCaseModuleTest {

    @Test
    fun `provideUsersUseCase returns GetUsersUseCase`() {
        val usersRepository = Mockito.mock(UsersRepository::class.java)
        val getUsersUseCase = UsersUseCaseModule.provideUsersUseCase(usersRepository)
        assertTrue(getUsersUseCase is GetUsersUseCase)
    }
}