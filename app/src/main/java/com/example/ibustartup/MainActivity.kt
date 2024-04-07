package com.example.ibustartup

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.ibustartup.ui.components.BottomBarNavigation
import com.example.ibustartup.ui.components.Navigation
import com.example.ibustartup.ui.screens.SignIn
import com.example.ibustartup.ui.theme.IBUStartupTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IBUStartupTheme {
                val navController = rememberNavController()
                
                Scaffold(bottomBar = { BottomBarNavigation(
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route)
                    })

                }) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}