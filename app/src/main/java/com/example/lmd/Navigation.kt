package com.example.lmd

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lmd.Pages.HomePage
import com.example.lmd.Pages.LoginPage
import com.example.lmd.Pages.MerchantPage
import com.example.lmd.Pages.MerchantSignup
import com.example.lmd.Pages.SignUpPage

@Composable
fun Navigation(modifier: Modifier = Modifier,authViewModel: AuthViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login",builder={
        composable("login"){
            LoginPage(modifier,navController, AuthViewModel())
        }
        composable("signup"){
            SignUpPage(modifier,navController,AuthViewModel())
        }
        composable("home"){
            HomePage(modifier,navController,AuthViewModel())
        }
        composable("Merchant-Page"){
            MerchantPage(modifier,navController,AuthViewModel())
        }
        composable("Merchant-Signup"){
            MerchantSignup(modifier,navController,AuthViewModel())
        }

    })
}