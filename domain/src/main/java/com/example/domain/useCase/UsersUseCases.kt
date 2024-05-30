package com.example.domain.useCase

/**
 * This data class groups all the use cases related to users.
 *
 * @property getUsersUseCase The use case for getting users.
 */
data class UsersUseCases(
    val getUsersUseCase: GetUsersUseCase
)