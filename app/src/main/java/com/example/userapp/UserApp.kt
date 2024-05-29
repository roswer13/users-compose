@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.userapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.userapp.ui.presentations.users.UsersScreen
import com.example.userapp.ui.presentations.users.UsersViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val usersViewModel: UsersViewModel = viewModel()
            UsersScreen(
                usersState = usersViewModel.usersUiState,
                contentPadding = it,
            )
        }
    }
}