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
    companion object{
        const val KEY1= "com.example.databaseconnectivity.mail"
        const val KEY2= "com.example.databaseconnectivity.name"
        const val KEY3= "com.example.databaseconnectivity.id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signin= findViewById<Button>(R.id.submit)
        val user=  findViewById<TextInputEditText>(R.id.et1)
        val pass= findViewById<TextInputEditText>(R.id.et2)
        val signUp= findViewById<Button>(R.id.SignUp)

        signin.setOnClickListener {
            val userName= user.text.toString()
            val password= pass.text.toString()
            if(userName.isNotEmpty()){
                if(password.isNotEmpty()) {
                    readData(userName, password)
                }else{
                    Toast.makeText(this,"Please enter your password.",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Please enter your User Id",Toast.LENGTH_SHORT).show()
            }
        }
        signUp.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun readData(userName: String,password:String) {
database=FirebaseDatabase.getInstance().getReference("Users")
        database.child(userName).get().addOnSuccessListener {
            if (it.exists()){
                database.child(password).get().addOnSuccessListener{
                  if (it.exists()){
                      val name =it.child("name").value
                      val email= it.child("email").value
                      val uniqueID= it.child("id").value

                      val intent= Intent(this,SecondActivity::class.java)
                      intent.putExtra(KEY1,email.toString())
                      intent.putExtra(KEY2,name.toString())
                      intent.putExtra(KEY3,uniqueID.toString())
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