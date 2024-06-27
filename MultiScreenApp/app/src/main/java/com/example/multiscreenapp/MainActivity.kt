package com.example.multiscreenapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
 companion object{
     const val KEY= "com.example.multiscreenapp.MainActivity.KEY"
 }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button=findViewById<Button>(R.id.button)
        var order2=findViewById<EditText>(R.id.order2)
        var order3=findViewById<EditText>(R.id.order3)
        var order4=findViewById<EditText>(R.id.order4)
        var order5=findViewById<EditText>(R.id.order5)
        button.setOnClickListener {
        val message = order2.text.toString()+" "+order3.text.toString()+" "+order4.text.toString()+" "+order5.text.toString()
        intent= Intent(this,Order::class.java)

            intent.putExtra(KEY,message)

            startActivity(intent)
        }
    }
}