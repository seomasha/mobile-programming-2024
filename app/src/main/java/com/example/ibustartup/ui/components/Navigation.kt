package com.example.ibustartup.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            Text(text = "Home")
        }
        composable("Startups") {
            Text(text = "Startups")
        }
        composable("Friends") {
            Text(text = "Friends")
        }
        composable("Activity") {
            Text(text = "Activity")
        }
        composable("Investors") {
            Text(text = "Investors")
        }
        composable("Profile") {
            Text(text = "Profile")
        }
    }
}