package com.example.multiscreenapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class Order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val orderOfCustomer= intent.getStringExtra(MainActivity.KEY)
        val textView= findViewById<TextView>(R.id.textView)
        textView.text= "Order placed "+ orderOfCustomer.toString()
    }
}