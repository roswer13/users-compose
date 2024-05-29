package com.example.userapp.ui.presentations.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapp.network.UsersApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class UsersViewModel : ViewModel() {
    var usersUiState: UsersState by mutableStateOf(UsersState.Loading)
        private set

    init {
        getUsers()
    }

    private fun getUsers() {

        viewModelScope.launch {
            usersUiState = UsersState.Loading
            usersUiState = try {
                val listResult = UsersApi.retrofitService.getUsers()
                UsersState.Success(listResult)
            } catch (e: IOException) {
                UsersState.Error
            } catch (e: HttpException) {
                UsersState.Error
            }
        }
    }
}