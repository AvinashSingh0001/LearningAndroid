package com.example.alertbox

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        dialog=Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))
        val button=findViewById<Button>(R.id.btn)
        val btnFeed=dialog.findViewById<Button>(R.id.btn1)
        val btnGood=dialog.findViewById<Button>(R.id.btn2)



        btnGood.setOnClickListener {
            dialog.dismiss()
        }
        btnFeed.setOnClickListener {
            {}
        }
        button.setOnClickListener {
            dialog.show()
        }

    }
}