
package com.example.createaccountapp

import LoginFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load LoginFragment as the default fragment when the app starts
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment()) // Use correct container ID
                .commit()
        }
    }

    // Method to switch to RegisterFragment
    fun switchToRegisterFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, RegisterFragment()) // Correct container ID
            .addToBackStack(null) // Adds the transaction to the back stack to enable "Back" navigation
            .commit()
    }

    // Method to switch back to LoginFragment
    fun switchToLoginFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LoginFragment()) // Correct container ID
            .addToBackStack(null)
            .commit()
    }
    fun switchToRecyclerFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, RecyclerFragment())
            .addToBackStack(null)
            .commit()
    }
}
