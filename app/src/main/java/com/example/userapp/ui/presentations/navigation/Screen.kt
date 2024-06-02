package com.example.userapp.ui.presentations.navigation

sealed class Screen(val route: String) {
    object Users : Screen("users_screen")
}
