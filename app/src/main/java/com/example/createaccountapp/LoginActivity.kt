package com.example.createaccountapp

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {

    // Properties for views using custom getters
    private val emailEditText: EditText
        get() = findViewById(R.id.emailEditText)

    private val passwordEditText: EditText
        get() = findViewById(R.id.passwordEditText)

    private val rememberMeCheckBox: CheckBox
        get() = findViewById(R.id.rememberMeCheckBox)

    private val nextButton: MaterialButton
        get() = findViewById(R.id.nextButton)

    private val newMemberTextView: TextView
        get() = findViewById(R.id.newMemberTextView)

    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account) // Correctly linked layout file

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up "Next" button click listener
        nextButton.setOnClickListener {
            handleLogin()
        }

        // Set up "New Member" text click listener
        newMemberTextView.setOnClickListener {
            navigateToRegister()
        }
    }

    private fun handleLogin() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        // Validate email
        if (!credentialsManager.isEmailValid(email)) {
            Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
            return
        }

        // Validate password
        if (!credentialsManager.isPasswordValid(password)) {
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }

        // Check if credentials match
        if (credentialsManager.areCredentialsValid(email, password)) {
            // Navigate to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToRegister() {
        // Navigate to registration page
        val intent = Intent(this, SecondPageActivity::class.java)
        startActivity(intent)
    }
}
