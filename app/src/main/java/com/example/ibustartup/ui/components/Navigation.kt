package com.example.ibustartup.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ibuPosition.backend.viewmodels.PositionViewModel
import com.example.ibustartup.R
import com.example.ibustartup.backend.tables.Startup
import com.example.ibustartup.backend.viewmodels.StartupEvent
import com.example.ibustartup.backend.viewmodels.StartupViewModel
import com.example.ibustartup.backend.viewmodels.UserViewModel
import com.example.ibustartup.data.CommentData
import com.example.ibustartup.data.FriendData
import com.example.ibustartup.data.FriendRequestData
import com.example.ibustartup.data.InvestorData
import com.example.ibustartup.data.NotificationData
import com.example.ibustartup.data.PositionData
import com.example.ibustartup.data.StartupData
import com.example.ibustartup.ui.screens.Friends
import com.example.ibustartup.ui.screens.Home
import com.example.ibustartup.ui.screens.Investors
import com.example.ibustartup.ui.screens.MyProfile
import com.example.ibustartup.ui.screens.Notifications
import com.example.ibustartup.ui.screens.SignIn
import com.example.ibustartup.ui.screens.SignUp
import com.example.ibustartup.ui.screens.Startups
import com.example.ibustartup.ui.theme.GrayStroke

@Composable
fun Navigation(positionViewModel: PositionViewModel, navController: NavHostController, userViewModel: UserViewModel, startupViewModel: StartupViewModel, showEditDialog: (Startup) -> Unit) {
    NavHost(navController = navController, startDestination = "SignUp") {
        composable("Home") {
            val comments = mutableListOf(
                CommentData(
                    profileImage = R.drawable.user,
                    name = "Sead Fikret",
                    "Komentar"
                )
            )
            val positions = mutableListOf(
                PositionData(
                    name = "Sead Masetic",
                    username = "seadmasetic",
                    description = "Testiranje",
                    profileImage = R.drawable.user,
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
                    profileImage = R.drawable.user,
                    positionImage = R.drawable.positionimage,
                    likeCount = 45,
                    commentCount = 25,
                    applyCount = 128,
                    comments = comments
                )
            )
            Home(positionViewModel = positionViewModel, modifier = Modifier, userViewModel=userViewModel)
        }
        composable("Startups") {
            Startups(startupViewModel)
        }
        composable("Friends") {
            val friends = listOf(
                FriendData("Sead", "Sead", R.drawable.positionimage),
                FriendData("Sead", "Sead", R.drawable.positionimage),
                FriendData("Sead", "Sead", R.drawable.positionimage)
            )
            val friendRequests = listOf(
                FriendRequestData("Sead", R.drawable.positionimage),
                FriendRequestData("Testiranje", R.drawable.positionimage)
            )
            Friends(friends = friends, friendRequests, navController)
        }
        composable("Activity") {
            val notifications = listOf(
                NotificationData(R.drawable.user, "Sead Masetic")
            )
            Notifications(notifications = notifications)
        }
        composable("Investors") {
            val investors = listOf(
                InvestorData("Sead", "Sead", R.drawable.positionimage),
                InvestorData("Sead", "Sead", R.drawable.positionimage),
                InvestorData("Sead", "Sead", R.drawable.positionimage)

            )
            Investors(investors = investors)
        }
        composable("MyProfile") {
            MyProfile(startupViewModel, userViewModel, showEditDialog)
        }
        composable("SignIn") {
            SignIn(navController, userViewModel)
        }
        composable("SignUp") {
            SignUp(navController, userViewModel)
        }
    }
}