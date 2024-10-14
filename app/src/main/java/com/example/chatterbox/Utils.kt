package com.example.chatterbox

import androidx.navigation.NavController

fun navigateTo(navController: NavController, route: String){
    navController.navigate(route = route){
        popUpToId
        launchSingleTop = true
    }
}