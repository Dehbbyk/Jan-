package com.debbie.jan_

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.debbie.jan_.screen.HomeScreen
import com.debbie.jan_.screen.LoginScreen
import com.debbie.jan_.screen.SignupScreen
import com.debbie.jan_.viewModel.AuthViewModel

@Composable
fun AppNavigation(authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    var isUserSignIn by rememberSaveable {authViewModel.isUserAuthenticated}
    var errorMessage by rememberSaveable { authViewModel.errorMessage }

    if(errorMessage.isNotEmpty()) {
        var context = LocalContext.current
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
        authViewModel.clearErrorMessage()
    }

    NavHost(
        navController = navController,
        startDestination = if(isUserSignIn){"home"}else{"login"}
    ){
        composable("login"){
            LoginScreen(navController, authViewModel)
        }
        composable("signup"){
            SignupScreen(navController, authViewModel)
        }
        composable("home"){
            HomeScreen(authViewModel)
        }
    }
}
