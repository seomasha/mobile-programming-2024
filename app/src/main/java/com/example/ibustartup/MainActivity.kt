package com.example.ibustartup

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ibustartup.ui.components.BottomBarNavigation
import com.example.ibustartup.ui.components.Header
import com.example.ibustartup.ui.components.Navigation
import com.example.ibustartup.ui.screens.SignIn
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.IBUStartupTheme

//Add composables to the routes
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IBUStartupTheme {
                val navController = rememberNavController()
                Scaffold(bottomBar = {
                    BottomBarNavigation(
                        navController = navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        })

                }, floatingActionButton = {
                    if(navController.currentBackStackEntryAsState().value?.destination?.route == "Home") {
                        FloatingActionButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.add), contentDescription = "")
                        }
                    }
                }) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}