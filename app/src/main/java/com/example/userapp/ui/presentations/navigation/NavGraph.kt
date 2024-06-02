package com.example.userapp.ui.presentations.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.userapp.ui.presentations.users.UsersScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = Screen.Users.route
    ) {
        composable(route = Screen.Users.route) {
            UsersScreen()
        }
    }
}