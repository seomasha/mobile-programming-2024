package com.example.ibustartup.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ibustartup.R
import com.example.ibustartup.data.CommentData
import com.example.ibustartup.data.PositionData
import com.example.ibustartup.ui.screens.Home
import com.example.ibustartup.ui.screens.MyProfile
import com.example.ibustartup.ui.screens.SignIn
import com.example.ibustartup.ui.screens.SignUp
import com.example.ibustartup.ui.theme.GrayStroke

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            val comments = mutableListOf(
                CommentData(
                    profileImage = R.drawable.profile,
                    name = "Sead Fikret",
                    "Komentar"
                )
            )
            val positions = mutableListOf(
                PositionData(
                    name = "Sead Masetic",
                    username = "seadmasetic",
                    description = "Testiranje",
                    profileImage = R.drawable.profile,
                    positionImage = R.drawable.positionimage,
                    likeCount = 45,
                    commentCount = 25,
                    applyCount = 128,
                    comments = comments
                ),
                PositionData(
                    name = "Sead Masetic",
                    username = "seadmasetic",
                    description = "Testiranje",
                    profileImage = R.drawable.profile,
                    positionImage = R.drawable.positionimage,
                    likeCount = 45,
                    commentCount = 25,
                    applyCount = 128,
                    comments = comments
                )
            )
            Home(positions = positions, modifier = Modifier)
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
        composable("MyProfile") {
            MyProfile()
        }
        composable("SignIn") {
            SignIn()
        }
        composable("SignUp") {
            SignUp()
        }
    }
}