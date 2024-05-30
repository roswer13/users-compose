package com.example.domain.useCase

import com.example.domain.model.Response
import com.example.domain.model.Support
import com.example.domain.model.User
import com.example.domain.repository.UsersRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class GetUsersUseCaseTest {

    private lateinit var getUsersUseCase: GetUsersUseCase
    private val usersRepository: UsersRepository = mock()

    @Before
    fun setUp() {
        getUsersUseCase = GetUsersUseCase(usersRepository)
    }

    @Test
    fun `invoke() should return response with users from repository`() = runBlocking {
        // Arrange
        val expectedResponse = Response(
            page = 1,
            perPage = 2,
            total = 2,
            totalPages = 2,
            data = listOf(
                User(1, "test@test.com", "John", "Doe", "https://i.pravatar.cc/300"),
                User(2, "test2@test.com", "Jane", "Doe", "https://i.pravatar.cc/300")
            ),
            support = Support(
                "https://reqres.in/#support-url", "https://reqres.in/#support-heading"
            )
        )
        `when`(usersRepository.getUsers()).thenReturn(flowOf(expectedResponse))

        // Act
        val actualUsers = getUsersUseCase().first()

        // Assert
        assertEquals(expectedResponse, actualUsers)
    }
}