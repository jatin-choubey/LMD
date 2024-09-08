package com.example.lmd.Pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lmd.AuthViewModel


@Composable
fun MerchantSignup(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel){
   var shopName by remember { mutableStateOf("") }
   var ownerName by remember { mutableStateOf("") }
   var email by remember { mutableStateOf("") }
   var phoneNumber by remember { mutableStateOf("") }
   var gstNumber by remember { mutableStateOf("") }
   var address by remember { mutableStateOf("") }
   var password by remember { mutableStateOf("") }
   var confirmPassword by remember { mutableStateOf("") }
   var errorMessage by remember { mutableStateOf("") }

   Column(
      modifier = Modifier
         .fillMaxSize()
         .padding(16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
   ) {
      Text(text = "Shopkeeper Signup",)

      Spacer(modifier = Modifier.height(20.dp))

      // Shop Name Field
      OutlinedTextField(
         value = shopName,
         onValueChange = { shopName = it },
         label = { Text("Shop Name") },
         modifier = Modifier.fillMaxWidth()
      )

      Spacer(modifier = Modifier.height(10.dp))

      // Owner's Name Field
      OutlinedTextField(
         value = ownerName,
         onValueChange = { ownerName = it },
         label = { Text("Owner's Name") },
         modifier = Modifier.fillMaxWidth()
      )

      Spacer(modifier = Modifier.height(10.dp))

      // Email Field
      OutlinedTextField(
         value = email,
         onValueChange = { email = it },
         label = { Text("Email") },
         modifier = Modifier.fillMaxWidth(),
         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
      )

      Spacer(modifier = Modifier.height(10.dp))

      // Phone Number Field
      OutlinedTextField(
         value = phoneNumber,
         onValueChange = { phoneNumber = it },
         label = { Text("Phone Number") },
         modifier = Modifier.fillMaxWidth(),
         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
      )

      Spacer(modifier = Modifier.height(10.dp))

      // GST Number Field
      OutlinedTextField(
         value = gstNumber,
         onValueChange = { gstNumber = it },
         label = { Text("GST Number") },
         modifier = Modifier.fillMaxWidth(),
         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
      )

      Spacer(modifier = Modifier.height(10.dp))

      // Address Field
      OutlinedTextField(
         value = address,
         onValueChange = { address = it },
         label = { Text("Address") },
         modifier = Modifier.fillMaxWidth()
      )

      Spacer(modifier = Modifier.height(10.dp))

      // Password Field
      OutlinedTextField(
         value = password,
         onValueChange = { password = it },
         label = { Text("Password") },
         modifier = Modifier.fillMaxWidth(),
         visualTransformation = PasswordVisualTransformation(),
         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
      )

      Spacer(modifier = Modifier.height(10.dp))

      // Confirm Password Field
      OutlinedTextField(
         value = confirmPassword,
         onValueChange = { confirmPassword = it },
         label = { Text("Confirm Password") },
         modifier = Modifier.fillMaxWidth(),
         visualTransformation = PasswordVisualTransformation(),
         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
      )

      Spacer(modifier = Modifier.height(20.dp))

      if (errorMessage.isNotEmpty()) {
       Text(text = "errorMessage", color = Color.Red)
         Spacer(modifier = Modifier.height(10.dp))
      }

      Button(
         onClick = {
            // Form validation
            if (shopName.isEmpty() || ownerName.isEmpty() || email.isEmpty() ||
               phoneNumber.isEmpty() || gstNumber.isEmpty() || address.isEmpty() ||
               password.isEmpty() || confirmPassword.isEmpty()) {
               errorMessage = "All fields are required!"
            } else if (password != confirmPassword) {
               errorMessage = "Passwords do not match!"
            } else {
               errorMessage = ""
               // Proceed with signup logic here
            }
         },
         modifier = Modifier.fillMaxWidth()
      ) {
         Text("Sign Up")
      }
   }
}
