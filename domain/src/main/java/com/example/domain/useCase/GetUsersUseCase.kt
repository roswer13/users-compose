package com.example.domain.useCase

import com.example.domain.model.ResponseData
import com.example.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for getting users.
 *
 * This class is a part of the domain layer and encapsulates the logic for retrieving users.
 * It is an example of the Command pattern and the Single Responsibility Principle.
 *
 * @property userRepository The repository instance, injected by Dagger.
 */
class GetUsersUseCase @Inject constructor(private val userRepository: UsersRepository) :
    BaseUseCase<Unit, Flow<ResponseData>>() {

    /**
     * Executes the use case of getting users.
     *
     * This function is a suspend function and should be called from a coroutine or another suspend function.
     *
     * @param params The parameters of the use case. In this case, it is Unit because no parameters are needed.
     * @return A Flow of ResponseData.
     */
    override fun execute(params: Unit): Flow<ResponseData> {
        return userRepository.getUsers()
    }
}
