package com.example.dialoguebox

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import com.example.dialoguebox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Are You Sure")
            builder.setIcon(R.drawable.exit)
            builder.setMessage("Do You want to Exit from this app?")
            builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })

            builder.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()
            })
            builder.show()
        }

        binding.btn2.setOnClickListener {
            val array = arrayOf("Gulab Jamun", "Mysore Pak", "Rasmalai", "Kaju Katli")
            val builder2 = AlertDialog.Builder(this)
            var choice= array[0]
            builder2.setTitle("Which is your favourite")
            builder2.setSingleChoiceItems(array, 0, DialogInterface.OnClickListener { dialog, i ->
                choice= array[i]
                Toast.makeText(this, "You have select ${array[i]}",  Toast.LENGTH_SHORT).show()
            })

            builder2.setMessage("choose your favourite sweet")
            builder2.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                binding.choice.text = choice
            })

            builder2.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()
            })
            builder2.show()
        }
        binding.btn3.setOnClickListener {
            val array = arrayOf("Gulab Jamun", "Mysore Pak", "Rasmalai", "Kaju Katli")
            val builder3 = AlertDialog.Builder(this)

            builder3.setTitle("Which is your favourite")
            builder3.setMultiChoiceItems(array, null,DialogInterface.OnMultiChoiceClickListener { dialog, i, b ->

                Toast.makeText(this,"You have selected ${array[i]}", Toast.LENGTH_SHORT).show()
            })

            builder3.setMessage("choose your favourite sweet")
            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->

            })

            builder3.setNegativeButton("CAncel", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()
            })
            builder3.show()
        }
    }
}