package com.example.userapp.di.usecase

import com.example.data.datasource.UsersApi
import com.example.data.repository.UsersRepositoryImpl
import com.example.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUsersUseCase(usersApi: UsersApi): UsersRepository {
        return UsersRepositoryImpl(usersApi)
    }
}