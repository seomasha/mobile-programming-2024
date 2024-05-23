package com.example.ibustartup.ui.screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ibustartup.R
import com.example.ibustartup.backend.viewmodels.UIState
import com.example.ibustartup.backend.viewmodels.UserEvent
import com.example.ibustartup.backend.viewmodels.UserViewModel
import com.example.ibustartup.ui.theme.DarkBlue
import com.example.ibustartup.ui.theme.LightBlue
import com.example.ibustartup.ui.theme.LightBlueBackground

@Composable
fun SignIn(navController: NavController, userViewModel: UserViewModel) {

    var email by remember {
        mutableStateOf("");
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    var alertDialogMessage by remember { mutableStateOf(String()) }
    var showDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "IBU | Startup",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp),
            color = DarkBlue,
            fontWeight = FontWeight.Bold
        )
        Image(
            painterResource(id = R.drawable.signin), modifier = Modifier
                .size(300.dp)
                .align(Alignment.CenterHorizontally), contentDescription = null
        )
        Text(
            text = "Sign in",
            fontSize = 36.sp,
            modifier = Modifier.padding(16.dp),
            color = DarkBlue,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(25.dp))
        TextField(
            value = email, onValueChange = { email = it },
            label = {
                Text(text = "Your email", fontWeight = FontWeight.Light)
            },
            modifier = Modifier
                .fillMaxWidth(0.90f)
                .align(Alignment.CenterHorizontally)
                .border(width = 1.dp, color = LightBlue, shape = RoundedCornerShape(8.dp))
                .clip(shape = RoundedCornerShape(8.dp)),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.password),
                    contentDescription = "Password icon",
                    tint = LightBlue
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password, onValueChange = { password = it },
            label = {
                Text(text = "Your password", fontWeight = FontWeight.Light)
            },
            modifier = Modifier
                .fillMaxWidth(0.90f)
                .align(Alignment.CenterHorizontally)
                .border(width = 1.dp, color = LightBlue, shape = RoundedCornerShape(8.dp))
                .clip(shape = RoundedCornerShape(8.dp)),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.mail),
                    contentDescription = "Email icon",
                    tint = LightBlue
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
            ),
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (!passwordVisible) R.drawable.showpass else R.drawable.hidepass

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(id = image),
                        contentDescription = "Show/Hide password",
                        tint = LightBlue,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(54.dp))

        Button(onClick = {
            userViewModel.resetUIState()
            navController.navigate("SignUp")
        }, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = LightBlue
        )) {
            Text(
                text = "Don't have an account?",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
            )
        }
        Spacer(modifier = Modifier.height(54.dp))
        Button(
            onClick = {
                userViewModel.onEvent(UserEvent.Login(email, password))
            }, modifier = Modifier
                .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = LightBlue
            )
        ) {
            Text("Sign in")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Error") },
                text = { Text(alertDialogMessage) },
                confirmButton = {
                    Button(onClick = {
                        showDialog = false
                        userViewModel.resetUIState()
                    }) {
                        Text("OK")
                    }
                }
            )
        }


        val uiState by userViewModel.uiState.observeAsState(initial = UIState.Loading)

        when(uiState) {
            is UIState.LoggedIn -> navController.navigate("Home")
            is UIState.Error -> {
                alertDialogMessage = (uiState as UIState.Error).message
                showDialog = true
            }
            else -> {}
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SignInPreview() {
    //SignIn()
}