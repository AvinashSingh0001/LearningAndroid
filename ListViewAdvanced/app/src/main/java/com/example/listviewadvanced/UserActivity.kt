package com.example.listviewadvanced

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)

        val name= intent.getStringExtra("Name")
        val phoneNumber= intent.getStringExtra("Phone")
        val imageID= intent.getIntExtra("Image",R.drawable.my)

        val nametv= findViewById<TextView>(R.id.name)
        val phoneTv= findViewById<TextView>(R.id.phone)
        val image = findViewById<CircleImageView>(R.id.profile_image)

        nametv.text= name
        phoneTv.text=phoneNumber
        image.setImageResource(imageID)
    }
}