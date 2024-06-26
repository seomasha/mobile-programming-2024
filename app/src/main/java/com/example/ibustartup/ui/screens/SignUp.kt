package com.example.ibustartup.ui.screens

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ibustartup.R
import com.example.ibustartup.backend.dao.UserDao
import com.example.ibustartup.backend.tables.User
import com.example.ibustartup.backend.viewmodels.UIState
import com.example.ibustartup.backend.viewmodels.UserEvent
import com.example.ibustartup.backend.viewmodels.UserViewModel
import com.example.ibustartup.ui.theme.DarkBlue
import com.example.ibustartup.ui.theme.LightBlue

@Composable
fun SignUp(navController: NavController, userViewModel: UserViewModel) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordRepeat by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var checkPassword by remember { mutableStateOf(false) }
    var checkEmail by remember { mutableStateOf(false) }
    var checkPasswordRepeat by remember { mutableStateOf(false) }

    var alertDialogMessage by remember { mutableStateOf(String()) }
    var showDialog by remember { mutableStateOf(false) }

    val uiState by userViewModel.uiState.observeAsState(initial = UIState.Registering)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(13.dp)
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp),
            color = DarkBlue,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier
                .padding(13.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.remote_work),
                contentDescription = "",
                modifier = Modifier.size(width = 350.dp, height = 250.dp)
            )
        }

        Text(
            text = "Sign Up",
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 24.dp),
            color = DarkBlue,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                enabled = true,
                label = {
                    Text(text = "Your name", fontWeight = FontWeight.Light)
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.namesurname),
                        contentDescription = "",
                        tint = LightBlue
                    )
                },
                isError = false,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .weight(1f),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = LightBlue,
                    unfocusedBorderColor = LightBlue
                )
            )

            Spacer(modifier = Modifier.size(width = 8.dp, height = 0.dp))

            OutlinedTextField(
                value = surname,
                onValueChange = { surname = it },
                enabled = true,
                label = {
                    Text(text = "Your surname", fontWeight = FontWeight.Light)
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.namesurname),
                        contentDescription = "",
                        tint = LightBlue
                    )
                },
                isError = false,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .weight(1f),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = LightBlue,
                    unfocusedBorderColor = LightBlue
                )
            )
        }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            enabled = true,
            label = {
                Text(text = "Your email", fontWeight = FontWeight.Light)
            },
            placeholder = {
                Text(text = "example@exmaple.com", fontWeight = FontWeight.Light)
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.mail),
                    contentDescription = "",
                    tint = LightBlue
                )
            },
            isError = checkEmail,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = LightBlue,
                unfocusedBorderColor = LightBlue
            )
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(text = "Your password", fontWeight = FontWeight.Light)
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.password),
                    contentDescription = "",
                    tint = LightBlue
                )
            },
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            isError = checkPassword,
            trailingIcon = {
                Icon(
                    painter = if (!showPassword) {
                        painterResource(id = R.drawable.showpass)
                    } else {
                        painterResource(id = R.drawable.hidepass)
                    },
                    contentDescription = "",
                    modifier = Modifier
                        .clickable(onClick = { showPassword = !showPassword })
                        .size(18.dp), tint = LightBlue
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = LightBlue,
                unfocusedBorderColor = LightBlue
            )
        )

        OutlinedTextField(
            value = passwordRepeat,
            onValueChange = { passwordRepeat = it },
            label = {
                Text(text = "Confirm your password", fontWeight = FontWeight.Light)
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.password),
                    contentDescription = "",
                    tint = LightBlue
                )
            },
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            isError = checkPasswordRepeat,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = LightBlue,
                unfocusedBorderColor = LightBlue
            )
        )

        Button(
            onClick = {
                navController.navigate("SignIn")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = LightBlue
            ),
        ) {
            Text(
                text = "Already have an account?",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
            )
        }

        Button(
            onClick = {
                var errorMessage = ""

                if (!checkEmail(email)) {
                    errorMessage += "Your email is invalid. "
                }
                else if (!passwordMatch(password, passwordRepeat)) {
                    errorMessage += "The passwords don't match. "
                }

                if (errorMessage.isNotEmpty()) {
                    alertDialogMessage = errorMessage.trim()
                    showDialog = true
                } else {
                    val user = User(firstName = name, lastName = surname, email = email, password = password)
                    userViewModel.onEvent(UserEvent.SaveUser(user))
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = LightBlue
            )
        ) {
            Text(
                text = "Sign Up",
                fontWeight = FontWeight.Bold
            )
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


        when (uiState) {
            is UIState.Success -> {
                navController.navigate("SignIn")
            }
            is UIState.Error -> {
                alertDialogMessage = (uiState as UIState.Error).message
                showDialog = true
            }
            else -> { /* Do nothing when the state is Loading */ }
        }
    }
}

fun checkEmail(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun passwordMatch(password: String, passwordRepeat: String): Boolean {
    return password == passwordRepeat
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    //SignUp()
}