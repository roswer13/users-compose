package com.example.data.repository

import com.example.data.datasource.UsersApi
import com.example.data.util.UtilTests
import kotlinx.coroutines.flow.first
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
class UsersRepositoryImplTest {

    @Mock
    private lateinit var usersApi: UsersApi
    private lateinit var usersRepositoryImpl: UsersRepositoryImpl

    @Before
    fun setUp() {
        usersRepositoryImpl = UsersRepositoryImpl(usersApi)
    }

    @Test
    fun `getUsersApiCall should return list of users`() = runTest {
        // Arrange
        val expectedResponse = UtilTests.dummyResponseData
        `when`(usersApi.getUsers()).thenReturn(expectedResponse)

        // Act
        val result = usersRepositoryImpl.getUsers().first()

        // Assert
        assertEquals(expectedResponse, result)
    }

    @Test
    fun `getUsersApiCall should return error flow when an exception occurs`() = runTest {
        // Arrange
        val expectedResponse = RuntimeException("An error occurred")
        `when`(usersApi.getUsers()).thenThrow(expectedResponse)

        // Act
        val result = runCatching { usersRepositoryImpl.getUsers().first() }

        // Assert
        assertTrue(result.isFailure)
        assertEquals(expectedResponse, result.exceptionOrNull())
    }
}