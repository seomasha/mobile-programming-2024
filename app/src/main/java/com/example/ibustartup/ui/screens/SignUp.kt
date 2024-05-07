package com.example.ibustartup.ui.screens

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.ibustartup.R
import com.example.ibustartup.ui.theme.DarkBlue
import com.example.ibustartup.ui.theme.LightBlue

@Composable
fun SignUp() {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordRepeat by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var checkPassword by remember { mutableStateOf(true) }
    var checkEmail by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(13.dp)
    ){
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp),
            color = DarkBlue,
            fontWeight = FontWeight.Bold
        )

        Row (
            modifier = Modifier
                .padding(13.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.remote_work),
                contentDescription = "",
                modifier = Modifier.size(width = 400.dp, height = 300.dp)
            )
        }

        Text(
            text = "Sign Up",
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 16.dp),
            color = DarkBlue,
            fontWeight = FontWeight.Bold
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(13.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
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
                    Text(text = "Enter your name")
                },
                placeholder = {
                    Text(text = "Enter your surname")
                },
                isError = false,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next),
                modifier = Modifier
                    .weight(1f),
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = LightBlue, unfocusedBorderColor = LightBlue)
            )

            Spacer(modifier = Modifier.size(width = 8.dp, height = 0.dp))

            OutlinedTextField(
                value = surname,
                onValueChange = { surname = it },
                enabled = true,
                label = {
                    Text(text = "Enter your surname")
                },
                placeholder = {
                    Text(text = "Enter your surname")
                },
                isError = false,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next),
                modifier = Modifier
                    .weight(1f),
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = LightBlue, unfocusedBorderColor = LightBlue)
            )
        }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            enabled = true,
            label = {
                Text(text = "Enter your email")
            },
            placeholder = {
                Text(text = "example@exmaple.com")
            },
            isError = checkEmail,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = LightBlue, unfocusedBorderColor = LightBlue)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it},
            label = {
                Text(text = "Enter your password")
            },
            visualTransformation = if(showPassword){
                VisualTransformation.None
            }
            else{
                PasswordVisualTransformation()
            },
            isError = !checkPassword,
            trailingIcon = {  Icon(
                painter = if(showPassword){
                    painterResource(id = android.R.drawable.ic_menu_view)
                }
                else{
                    painterResource(id = android.R.drawable.ic_menu_view)
                },
                contentDescription = "",
                modifier = Modifier.clickable(onClick = {showPassword = !showPassword }))
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = LightBlue, unfocusedBorderColor = LightBlue)
        )

        OutlinedTextField(
            value = passwordRepeat,
            onValueChange = { passwordRepeat = it},
            label = {
                Text(text = "Confirm your password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = !checkPassword,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = LightBlue, unfocusedBorderColor = LightBlue)
        )

        Button(
            onClick = {
                checkPassword = password == passwordRepeat
                checkEmail = !checkEmail(email)},
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
    }
}

fun checkEmail(email: String): Boolean{
    return  Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview(){
    SignUp()
}