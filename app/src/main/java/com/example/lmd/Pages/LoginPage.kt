package com.example.lmd.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lmd.AuthViewModel
import com.example.lmd.R

@Composable
fun LoginPage(modifier: Modifier = Modifier,navController: NavController,authViewModel: AuthViewModel)  {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column (modifier=modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, 
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = "LAST MINUTE DEALS",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
      Text(text = "Login Page", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(text = "Email")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(text = "Password")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {

        }){
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Don't Have an Account ??")
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "SIGN UP",
                color = Color.Blue,
                modifier = Modifier.clickable { navController.navigate("signup") }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Or continue with")
        Spacer(modifier = Modifier.height(16.dp))
        Row (horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()){
            Image(painter = painterResource(R.drawable.google_icon), contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clickable { /* Handle Google login */ }
            )
        }
        Spacer(modifier = Modifier.height(96.dp))
        Text(text = "Merchant-SignUp",
            color = Color.Blue,
            modifier=Modifier.clickable { navController.navigate("Merchant-Signup") })
    }
}