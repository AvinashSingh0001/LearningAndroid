package com.example.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         supportActionBar?.hide()
        Handler().postDelayed({
            var intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
        },3000)
    }
}
