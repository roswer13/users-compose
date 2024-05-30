package com.example.domain.useCase

/**
 * Executes the use case of getting users.
 *
 * This function is a suspend function and should be called from a coroutine or another suspend function.
 *
 * @param params The parameters of the use case. In this case, it is Unit because no parameters are needed.
 * @return A Flow of ResponseData.
 */
abstract class BaseUseCase<in Params, out T> {

    /**
     * Executes the use case.
     *
     * This is where the actual work of the use case is done. It is abstract because all use cases
     * will have different implementations of this method.
     *
     * @param params the parameters required to execute the use case.
     * @return the result of the use case.
     */
    abstract fun execute(params: Params): T
}