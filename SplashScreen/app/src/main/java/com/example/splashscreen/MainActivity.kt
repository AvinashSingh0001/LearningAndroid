package com.example.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,   // uses to hide the status bar
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler(Looper.getMainLooper()).postDelayed({     // This is preferred because it will ensures that flow of execution
            val intent = Intent(this, SignUp::class.java)  // goes to the hand of MainLooper, otherwise if any
            startActivity(intent)    // heavy task is performed then code operation will lag. As well first is thread safe.
            finish()
        }, 3000);

        /*
        Handler().postDelayed({
            var intent= Intent(this,SignUp::class.java)
            startActivity(intent)
        },3000)
         */
    }
}
