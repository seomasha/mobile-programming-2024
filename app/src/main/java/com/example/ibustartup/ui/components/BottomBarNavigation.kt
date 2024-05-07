package com.example.ibustartup.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ibustartup.R
import com.example.ibustartup.data.NavigationItem
import com.example.ibustartup.ui.theme.LightBlue

@Composable
fun BottomBarNavigation(
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (NavigationItem) -> Unit
) {

    val items = mutableListOf(
        NavigationItem(
            title = "Home",
            route = "Home",
            selectedIcon = R.drawable.home_filled,
            unselectedIcon = R.drawable.home
        ),
        NavigationItem(
            title = "Startups",
            route = "Startups",
            selectedIcon = R.drawable.startups_filled,
            unselectedIcon = R.drawable.startups
        ),
        NavigationItem(
            title = "Friends",
            route = "Friends",
            selectedIcon = R.drawable.friends_filled,
            unselectedIcon = R.drawable.friends
        ),
        NavigationItem(
            title = "Activity",
            route = "Activity",
            selectedIcon = R.drawable.notifications_filled,
            unselectedIcon = R.drawable.notifications
        ),
        NavigationItem(
            title = "Investors",
            route = "Investors",
            selectedIcon = R.drawable.investors_filled,
            unselectedIcon = R.drawable.investors
        ),
        NavigationItem(
            title = "My Profile",
            route = "MyProfile",
            selectedIcon = R.drawable.myprofile_filled,
            unselectedIcon = R.drawable.myprofile
        )
    )

    val backstackEntry = navController.currentBackStackEntryAsState()
    NavigationBar(containerColor = Color.White, tonalElevation = 5.dp) {
        items.forEach { item ->
            val selected = item.route == backstackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = {
                    onItemClick(item)
                },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = if (selected) item.selectedIcon else item.unselectedIcon),
                            contentDescription = item.title,
                            tint = LightBlue
                        )
                        Text(text = item.title, textAlign = TextAlign.Center, fontSize = 12.sp)
                    }
                },
            )
        }
    }
}

@Preview
@Composable
private fun BottomBarNavigationPreview() {
    //BottomBarNavigation()
}