package com.example.createaccountapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.util.Log

class SecondPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page2)

        // Log for debugging
        Log.d("SecondPageActivity", "Activity loaded successfully!")

        // Navigation to LoginActivity
        val alreadyMemberTextView = findViewById<TextView>(R.id.alreadyMemberTextView)
        alreadyMemberTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}

