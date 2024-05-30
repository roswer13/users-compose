package com.example.domain.useCase

import com.example.domain.repository.UsersRepository

/**
 * This class represents a use case for getting users.
 * It uses the UsersRepository to fetch the users.
 *
 * @property repository The repository used to fetch the users.
 */
class GetUsersUseCase(private val repository: UsersRepository) {
    /**
     * This function invokes the getUsers function from the repository.
     *
     * @return The result of the getUsers function from the repository.
     */
    operator fun invoke() = repository.getUsers()
}
