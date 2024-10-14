package com.example.chatterbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.chatterbox.ui.theme.ChatterBoxTheme
import androidx.navigation.compose.composable
import com.example.chatterbox.screens.LoginScreen
import com.example.chatterbox.screens.SignupScreen
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint

sealed class DestinationScreen(var route: String){
    object Signup: DestinationScreen("signup")
    object Login: DestinationScreen("login")
    object Profile: DestinationScreen("profile")
    object ChatList: DestinationScreen("chatList")
    object SingleChat: DestinationScreen("singleChat/{chatId}"){
        fun createRoute(chatId: String) = "singleChat/$chatId"
    }
    object StatusList: DestinationScreen("statusList")
    object SingleStatus: DestinationScreen("singleStatus/{statusId}"){
        fun createRoute(statusId: String) = "singleStatus/$statusId"
    }
}

@AndroidEntryPoint class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           ChatterBoxRootApp()
        }
    }
}

@Composable
fun ChatterBoxRootApp(){
    val navController = rememberNavController()
    val viewModel = hiltViewModel<ChatterBoxViewModel>()
    ChatterBoxTheme {
       Scaffold { innerPadding ->
           NavHost(
               navController = navController,
               startDestination = DestinationScreen.Signup.route,
               modifier = Modifier.padding(innerPadding))
           {
               composable(DestinationScreen.Signup.route){
                   SignupScreen(navController, viewModel)
               }
               composable(DestinationScreen.Login.route){
                   LoginScreen(navController, viewModel)
               }
           }
       }
    }
}

