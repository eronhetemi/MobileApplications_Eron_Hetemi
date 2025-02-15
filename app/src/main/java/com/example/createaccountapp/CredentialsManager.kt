package com.example.createaccountapp

import android.content.Context
import android.content.SharedPreferences
import android.util.Patterns

class CredentialsManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("user_credentials", Context.MODE_PRIVATE)

    // Check if the email matches the correct format
    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Check if the password is valid (simple check for now)
    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }

    // Register a new user
    fun register(email: String, password: String): Boolean {
        if (sharedPreferences.contains(email)) {
            return false // Email already exists
        }
        sharedPreferences.edit().putString(email, password).apply() // Save credentials
        return true // Registration successful
    }

    // Check if credentials are valid
    fun areCredentialsValid(email: String, password: String): Boolean {
        val savedPassword = sharedPreferences.getString(email, null)
        return savedPassword == password
    }
}