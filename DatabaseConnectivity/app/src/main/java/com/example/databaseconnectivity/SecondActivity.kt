package com.example.databaseconnectivity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val mail= intent.getStringExtra(SignInActivity.KEY1)
        val name = intent.getStringExtra(SignInActivity.KEY2)
        val id= intent.getStringExtra(SignInActivity.KEY3)

        val name1= findViewById<TextView>(R.id.textView)
        name1.text= "Welcome, "+name.toString()
        val mail1= findViewById<TextView>(R.id.mail)
        mail1.text= mail.toString()
        val id1= findViewById<TextView>(R.id.userid)
        id1.text=id.toString()
    }
}