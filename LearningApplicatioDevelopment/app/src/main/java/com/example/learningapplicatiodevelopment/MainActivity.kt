package com.example.learningapplicatiodevelopment

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnupload= findViewById<Button>(R.id.btnUpload)
        val btnDownload= findViewById<Button>(R.id.btnDownload)

        btnupload.setOnClickListener{
            Toast.makeText(applicationContext, "Uploading...", Toast.LENGTH_LONG).show()
        }
        btnDownload.setOnClickListener{
            Toast.makeText(applicationContext, "Downloading...", Toast.LENGTH_SHORT).show()
        }
    }
}