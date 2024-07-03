package com.example.databaseconnectivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {
    lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_in)
        val signin= findViewById<Button>(R.id.submit)
        val user=  findViewById<TextInputEditText>(R.id.et1)
        val pass= findViewById<TextInputEditText>(R.id.et2)

        signin.setOnClickListener {
            val userName= user.text.toString()
            val password= pass.text.toString()
            if(userName.isNotEmpty()){
                readData(userName,password)
            }else{
                Toast.makeText(this,"Please enter right User Id",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(userName: String,password:String) {
database=FirebaseDatabase.getInstance().getReference("Users")
        database.child(userName).get().addOnSuccessListener {
            if (it.exists()){
                database.child(password).get().addOnSuccessListener{
                  if (it.exists()){
                      intent= Intent(applicationContext,SecondActivity::class.java)
                      startActivity(intent)
                  }else{
                      Toast.makeText(this,"Please enter correct password.",Toast.LENGTH_SHORT).show()
                  }
                }
            }else{
                Toast.makeText(this,"Sorry, userId does not exist",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{
            Toast.makeText(this,"Can't able to find this userID due to some issue.",Toast.LENGTH_SHORT).show()
        }
    }
}