package com.example.photoframe

import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var currentImage=0
    lateinit var image:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       val prev= findViewById<ImageView>(R.id.prev)
        val next= findViewById<ImageView>(R.id.next)

        prev.setOnClickListener{
            val currentImageString= "pic$currentImage"
            val currentImageInt=this.resources.getIdentifier(currentImageString,"id",packageName)
            image = findViewById(currentImageInt)
            image.alpha=0f

            currentImage = (4+currentImage-1)%4

            val currentImageToShowString= "pic$currentImage"
            val currentImageToShowInt=this.resources.getIdentifier(currentImageToShowString,"id",packageName)
            image = findViewById(currentImageToShowInt)
            image.alpha=1f
        }
        next.setOnClickListener{
            val currentImageString= "pic$currentImage"
            val currentImageInt=this.resources.getIdentifier(currentImageString,"id",packageName)
            image = findViewById(currentImageInt)
            image.alpha=0f

            currentImage = (4+currentImage + 1)%4

            val currentImageToShowString= "pic$currentImage"
            val currentImageToShowInt=this.resources.getIdentifier(currentImageToShowString,"id",packageName)
            image = findViewById(currentImageToShowInt)
            image.alpha=1f
        }
    }
}