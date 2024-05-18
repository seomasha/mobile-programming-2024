package com.example.ibustartup

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.ibustartup.backend.AppDataContainer
import com.example.ibustartup.backend.IBUStartupDatabase
import com.example.ibustartup.backend.dao.UserDao
import com.example.ibustartup.backend.repositories.UserRepository
import com.example.ibustartup.backend.tables.Startup
import com.example.ibustartup.backend.tables.User
import com.example.ibustartup.backend.viewmodels.StartupEvent
import com.example.ibustartup.backend.viewmodels.StartupViewModel
import com.example.ibustartup.backend.viewmodels.UserViewModel
import com.example.ibustartup.ui.components.BottomBarNavigation
import com.example.ibustartup.ui.components.Header
import com.example.ibustartup.ui.components.Navigation
import com.example.ibustartup.ui.screens.SignIn
import com.example.ibustartup.ui.screens.SignUp
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.IBUStartupTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//Add composable to the routes
class MainActivity : ComponentActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var startupViewModel: StartupViewModel

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appContainer = AppDataContainer(applicationContext)

        userViewModel = UserViewModel(appContainer.userRepository)
        startupViewModel = StartupViewModel(appContainer.startupRepository)

        setContent {
            /*
            val user = User("Sead", "Masetic", "maseticsead@gmail.com", "sony")
            GlobalScope.launch {
                IBUStartupDatabase.getDatabase(applicationContext).userDao().insertUser(user)
            }
            */
            var showDialog by remember { mutableStateOf(false) }
            var startupName by remember { mutableStateOf("") }
            var startupDescription by remember { mutableStateOf("") }

            IBUStartupTheme {
                if (showDialog) {
                    Dialog(onDismissRequest = { showDialog = false }) {
                        Column (
                            modifier = Modifier
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(15.dp)
                                )
                                .padding(15.dp)
                        ){
                            Text(text = "Enter Startup Details")
                            OutlinedTextField(
                                value = startupName,
                                onValueChange = { startupName = it },
                                label = { Text("Startup Name") }
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            OutlinedTextField(
                                value = startupDescription,
                                onValueChange = { startupDescription = it },
                                label = { Text("Startup Description") }
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(onClick = {
                                startupViewModel.onEvent(StartupEvent.AddStartup(Startup(name = startupName, username = startupDescription)))
                                // startupViewModel.onEvent(StartupEvent.GetStartups)
                                showDialog = false
                            }) {
                                Text("Create")
                            }
                        }
                    }
                }

                val navController = rememberNavController()

                Scaffold(bottomBar = {
                    if (navController.currentBackStackEntryAsState()?.value?.destination?.route != "SignIn" && navController.currentBackStackEntryAsState()?.value?.destination?.route != "SignUp") {
                        BottomBarNavigation(
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            })
                    }

                }, floatingActionButton = {
                    if (navController.currentBackStackEntryAsState().value?.destination?.route == "Home") {
                        FloatingActionButton(onClick = {
                            /*
                            val user = User("Sead", "Sead" , "sead", "sead")
                            GlobalScope.launch {
                                AppDataContainer(applicationContext).userRepository.insert(user)
                            }
                             */
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.add),
                                contentDescription = "Home FAB"
                            )
                        }
                    } else if (navController.currentBackStackEntryAsState().value?.destination?.route == "MyProfile") {
                        FloatingActionButton(onClick = {
                            showDialog = true
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.add),
                                contentDescription = "MyProfile FAB"
                            )
                        }
                    }
                }, topBar = {
                    if (navController.currentBackStackEntryAsState()?.value?.destination?.route != "SignIn" && navController.currentBackStackEntryAsState()?.value?.destination?.route != "SignUp") {
                        Header(
                            modifier = Modifier
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(
                                        bottomStart = 15.dp,
                                        bottomEnd = 15.dp
                                    )
                                )
                                .border(
                                    width = 2.dp,
                                    color = GrayStroke,
                                    shape = RoundedCornerShape(
                                        bottomEnd = 15.dp,
                                        bottomStart = 15.dp
                                    )
                                ), navController = navController, userViewModel = userViewModel
                        )
                    }

                    Log.d(
                        "ROUTE",
                        navController.currentBackStackEntryAsState()?.value?.destination?.route
                            ?: "Not a route"
                    )
                }) {
                    if (navController.currentBackStackEntryAsState()?.value?.destination?.route == "SignIn") {
                        SignIn(navController = navController, userViewModel = userViewModel)
                    } else if (navController.currentBackStackEntryAsState()?.value?.destination?.route == "SignUp") {
                        SignUp(navController = navController, userViewModel = userViewModel)
                    } else {
                        Navigation(navController = navController, userViewModel = userViewModel, startupViewModel = startupViewModel)
                    }
                }

            }
        }
    }
}
