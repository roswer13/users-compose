package com.example.userapp.ui.presentations.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.ResponseData
import com.example.domain.useCase.GetUsersUseCase
import com.example.data.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _uiStateUsers: MutableStateFlow<UiState<ResponseData>> =
        MutableStateFlow(UiState.Loading)
    val uiStateUsers: StateFlow<UiState<ResponseData>> = _uiStateUsers

    fun getUsers() {
        getUsersUseCase.execute(Unit).onEach { users ->
            _uiStateUsers.value = UiState.Success(users)
        }.catch { e ->
            _uiStateUsers.value = UiState.Error(e.message.toString())
        }.launchIn(viewModelScope)
    }
}