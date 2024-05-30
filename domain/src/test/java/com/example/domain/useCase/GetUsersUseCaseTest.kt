package com.example.domain.useCase

import com.example.domain.model.ResponseData
import com.example.domain.model.Support
import com.example.domain.model.User
import com.example.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetUsersUseCaseTest {

    @Mock
    private lateinit var usersRepository: UsersRepository
    private lateinit var getUsersUseCase: GetUsersUseCase

    @Before
    fun setUp() {
        getUsersUseCase = GetUsersUseCase(usersRepository)
    }

    @Test
    fun `execute() should return response with users from repository`() = runTest {
        // Arrange
        val expectedResponseData = ResponseData(
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
        `when`(usersRepository.getUsers()).thenReturn(flowOf(expectedResponseData))

        // Act
        val result = getUsersUseCase.execute(Unit).first()

        // Assert
        assertEquals(expectedResponseData, result)
    }

    @Test
    fun `execute() should return error flow when repository throws exception`() = runTest {
        // Arrange
        val exception = Exception("An error occurred")
        val flow: Flow<ResponseData> = flow { throw exception }
        `when`(usersRepository.getUsers()).thenReturn(flow)

        // Act
        val result = runCatching { getUsersUseCase.execute(Unit).first() }

        // Assert
        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
    }
}