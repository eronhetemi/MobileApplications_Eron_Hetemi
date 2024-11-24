package com.example.createaccountapp

import android.util.Patterns

class CredentialsManager {

    private val validEmail = "test@te.st"
    private val validPassword = "1234"

    // Check if the email matches the correct format
    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Check if the password is valid (no special requirements in this case)
    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }

    // Check if credentials match the hardcoded ones
    fun areCredentialsValid(email: String, password: String): Boolean {
        return email == validEmail && password == validPassword
    }
}
