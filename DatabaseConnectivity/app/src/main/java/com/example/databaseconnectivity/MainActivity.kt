package com.example.databaseconnectivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            val signUp= findViewById<Button>(R.id.button)
            val emai= findViewById<TextInputEditText>(R.id.inputText)
            val passwor= findViewById<TextInputEditText>(R.id.inputText2)
            val nam= findViewById<TextInputEditText>(R.id.inputText1)
            val useriD= findViewById<TextInputEditText>(R.id.inputText3)
            val signIn= findViewById<Button>(R.id.signIn)

        signUp.setOnClickListener {
            val email= emai.text.toString()
            val password= passwor.text.toString()
            val name= nam.text.toString()
            val userID= useriD.text.toString()

            val user= User(name, email, password, userID)

            database= FirebaseDatabase.getInstance().getReference("Users")
            database.child(userID).setValue(user).addOnSuccessListener {
                 nam.text?.clear()
                emai.text?.clear()
                passwor.text?.clear()
                useriD.text?.clear()
                
                Toast.makeText(this,"Your resigtered successfully, please login now.", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Failed, Sorry for inconvenience.", Toast.LENGTH_SHORT).show()
            }
        }
       signIn.setOnClickListener {
           val intent= Intent(this,SignInActivity::class.java)
           startActivity(intent)
       }
    }
}