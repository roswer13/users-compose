package com.example.userapp.di.usecase

import com.example.domain.repository.UsersRepository
import com.example.domain.useCase.GetUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UsersUseCaseModule {
    @Provides
    fun provideUsersUseCase(usersRepository: UsersRepository): GetUsersUseCase {
        return GetUsersUseCase(usersRepository)
    }
}