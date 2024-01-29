package com.debbie.jan_.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.debbie.jan_.viewModel.AuthViewModel

@Composable
fun HomeScreen(authViewModel: AuthViewModel) {
    Column{
        Text("Welcome to home screen")
        Button(onClick = {authViewModel.logout() }) {
            Text(text = "Signout")
        }
    }
}