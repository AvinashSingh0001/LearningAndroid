package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignment2.databinding.ActivityMainScreenBinding

class MainScreen : AppCompatActivity() {
    lateinit var binding :ActivityMainScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {
            val intent= Intent(this,SignIn::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener {
            val intent= Intent(this,SignUp::class.java)
            startActivity(intent)
        }

    }
}