package com.example.domain.useCase

import com.example.domain.model.ResponseData
import com.example.domain.model.Support
import com.example.domain.model.User
import com.example.domain.repository.UsersRepository
import com.example.domain.util.UtilTests
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
        val expectedResponseData = UtilTests.dummyResponseData
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