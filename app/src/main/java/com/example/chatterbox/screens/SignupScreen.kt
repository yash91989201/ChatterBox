package com.example.chatterbox.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.chatterbox.ChatterBoxViewModel
import com.example.chatterbox.DestinationScreen
import com.example.chatterbox.R
import com.example.chatterbox.navigateTo

@Composable
fun SignupScreen(navController: NavController, viewModel: ChatterBoxViewModel){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().wrapContentHeight().verticalScroll((rememberScrollState()))
        ) {
            val focus = LocalFocusManager.current
            val nameState = remember { mutableStateOf(TextFieldValue()) }
            val numberState = remember { mutableStateOf(TextFieldValue()) }
            val emailState = remember { mutableStateOf(TextFieldValue()) }
            val passwordState = remember { mutableStateOf(TextFieldValue()) }

            Image(
                contentDescription = "App Logo",
                painter = painterResource(R.drawable.app_logo),
                modifier = Modifier.height(160.dp).width(80.dp).padding(top = 16.dp).padding(8.dp)
            )
            Text(
                text = "Get started today !",
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(
                label = {Text(text = "Name")},
                value = nameState.value,
                onValueChange = { it-> nameState.value = it},
                modifier = Modifier.padding(8.dp)
            )
            OutlinedTextField(
                label = {Text(text = "Number")},
                value = numberState.value,
                onValueChange = { it-> numberState.value = it},
                modifier = Modifier.padding(8.dp)
            )
            OutlinedTextField(
                label = {Text(text = "Email")},
                value = emailState.value,
                onValueChange = { it-> emailState.value = it},
                modifier = Modifier.padding(8.dp)
            )
            OutlinedTextField(
                label = {Text(text = "Password")},
                value = passwordState.value,
                onValueChange = { it-> passwordState.value = it},
                modifier = Modifier.padding(8.dp)
            )

            Button(
                onClick = { navigateTo(navController, DestinationScreen.Login.route) },
                modifier = Modifier.padding(8.dp),
            ) {
                Text("Sign Up")
            }

            TextButton(
                onClick = { navigateTo(navController, DestinationScreen.Login.route) },
            ) {
                Text("Already a user? Login here", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}