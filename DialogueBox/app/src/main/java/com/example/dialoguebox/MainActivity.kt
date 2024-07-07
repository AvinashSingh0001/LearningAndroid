package com.example.dialoguebox

import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialoguebox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
         val builder= AlertDialog.Builder(this)
            builder.setTitle("Are You Sure")
            builder.setIcon(R.drawable.close)
            builder.setMessage("Do You want to Exit from this app?")
            builder.setPositiveButton("Yes",DialogInterface.OnClickListener{
                dialogInterface, i ->
                finish()
            })

            builder.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()
            })
  builder.show()

        }


    }
}