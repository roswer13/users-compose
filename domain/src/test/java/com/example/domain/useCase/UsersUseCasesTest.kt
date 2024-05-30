package com.example.domain.useCase

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class UsersUseCasesTest {

    @Mock
    private lateinit var getUsersUseCase: GetUsersUseCase
    private lateinit var usersUseCases: UsersUseCases

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        usersUseCases = UsersUseCases(getUsersUseCase)
    }

    @Test
    fun usersUseCasesContainsExpectedUseCase() {
        assertEquals(getUsersUseCase, usersUseCases.getUsersUseCase)
    }
}