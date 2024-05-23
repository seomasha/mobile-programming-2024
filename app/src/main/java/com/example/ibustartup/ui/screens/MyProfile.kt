package com.example.ibustartup.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.compose.rememberNavController
import com.example.ibustartup.R
import com.example.ibustartup.backend.tables.Startup
import com.example.ibustartup.backend.tables.User
import com.example.ibustartup.backend.viewmodels.StartupEvent
import com.example.ibustartup.backend.viewmodels.StartupUIState
import com.example.ibustartup.backend.viewmodels.StartupViewModel
import com.example.ibustartup.backend.viewmodels.UserEvent
import com.example.ibustartup.backend.viewmodels.UserViewModel
import com.example.ibustartup.data.StartupData
import com.example.ibustartup.ui.components.Card
import com.example.ibustartup.ui.theme.DarkBlue
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue
import com.example.ibustartup.ui.theme.LightGray

@Composable
fun MyProfile(
    startupViewModel: StartupViewModel,
    userViewModel: UserViewModel,
    showEditDialog: (Startup) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    val startupsState by startupViewModel.uiState.collectAsState()
    var selectedStartup by remember { mutableStateOf<Startup?>(null) }
    var showEditDialog by remember { mutableStateOf(false) }
    var showEditProfileDialog by remember { mutableStateOf(false) }
    var user by remember { mutableStateOf<User?>(null) }

    LaunchedEffect(userViewModel.getLoggedInUserId()) {
        startupViewModel.onEvent(StartupEvent.GetStartupsByUserID(userViewModel.getLoggedInUserId()))
    }

    user = userViewModel.getUserById(userViewModel.getLoggedInUserId())

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        //val navController = rememberNavController()
        Row(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(top = 70.dp)
                .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp))
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(125.dp)
                    .clip(shape = CircleShape)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "${user!!.firstName} ${user!!.lastName}",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkBlue
                )
                Text(
                    text = "@${user!!.firstName}.${user!!.lastName}",
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        showEditProfileDialog = true
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = LightBlue
                    )
                ) {
                    Text(text = "Edit my profile")
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(
                        color = Color.White, shape = RoundedCornerShape(8.dp)
                    )
                    .size(180.dp)
                    .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "My friends",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkBlue,
                    modifier = Modifier.padding(8.dp)
                )
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Friend",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Friend",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Friend",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .background(
                        color = Color.White, shape = RoundedCornerShape(8.dp)
                    )
                    .size(180.dp)
                    .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Suggested friends",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkBlue,
                    modifier = Modifier.padding(8.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp))
                        .background(color = LightGray, shape = RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Sead Masetic",
                        color = LightBlue,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 12.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp))
                        .background(color = LightGray, shape = RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Fikret Zajmovic",
                        color = LightBlue,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 12.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        when (startupsState) {
            is StartupUIState.Loading -> {
                CircularProgressIndicator()
            }

            is StartupUIState.SuccessWithData -> {
                val startups = (startupsState as StartupUIState.SuccessWithData).startups
                val groupedStartups = startups.chunkedPairs()

                LazyColumn(modifier = Modifier.padding(bottom = 80.dp)) {
                    items(groupedStartups) { startupPair ->
                        Row(modifier = Modifier.padding(12.dp)) {
                            startupPair.forEach { startupData ->
                                Log.d("Loaded startups", "$startupData")
                                if (startupData != null) {
                                    Card(
                                        name = startupData.name,
                                        username = startupData.username,
                                        buttonText = "Edit",
                                        image = R.drawable.positionimage,
                                        onClick = {
                                            showEditDialog = true
                                            selectedStartup = startupData
                                            showEditDialog(startupData)
                                        }
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                } else {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                }
            }

            is StartupUIState.Error -> {
                val errorMessage = (startupsState as StartupUIState.Error).message
                Text(text = errorMessage)
            }

            is StartupUIState.Success -> {}
        }
        Spacer(modifier = Modifier.weight(1f))
        FloatingActionButton(onClick = { showDialog = true }) {
            Icon(
                painter = painterResource(id = R.drawable.add),
                contentDescription = "MyProfile FAB"
            )
        }
        if (showEditDialog) {
            Dialog(onDismissRequest = { showEditDialog = false }) {
                Column(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(15.dp))
                        .padding(15.dp)
                ) {
                    var name by remember { mutableStateOf(selectedStartup!!.name) }
                    var description by remember { mutableStateOf(selectedStartup!!.username) }

                    Text(text = "Edit Startup Details")
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Name") }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("Description") }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Button(onClick = {
                            val updatedStartup =
                                selectedStartup!!.copy(name = name, username = description)
                            startupViewModel.onEvent(StartupEvent.EditStartup(updatedStartup))
                            showEditDialog = false
                        }) {
                            Text("Save")
                        }
                        Button(
                            onClick = {
                                startupViewModel.onEvent(StartupEvent.DeleteStartup(selectedStartup!!))
                                showEditDialog = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.White,
                                containerColor = Color.Red
                            )
                        )
                        {
                            Text("Delete")
                        }
                    }
                }
            }
        }
        if (showEditProfileDialog) {
            Dialog(onDismissRequest = { showEditProfileDialog = false }) {
                Column(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(15.dp))
                        .padding(15.dp)
                ) {
                    var firstname by remember { mutableStateOf(user!!.firstName) }
                    var lastname by remember { mutableStateOf(user!!.lastName) }

                    Text(text = "Edit Profile Details")
                    OutlinedTextField(
                        value = firstname,
                        onValueChange = { firstname = it },
                        label = { Text("First Name") }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = lastname,
                        onValueChange = { lastname = it },
                        label = { Text("Last Name") }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Button(onClick = {
                            val updatedUser =
                                user!!.copy(firstName = firstname, lastName = lastname)
                            userViewModel.onEvent(UserEvent.EditUser(updatedUser))
                            showEditProfileDialog = false
                        }) {
                            Text("Save")
                        }
                    }
                }
            }
        }
    }
}

