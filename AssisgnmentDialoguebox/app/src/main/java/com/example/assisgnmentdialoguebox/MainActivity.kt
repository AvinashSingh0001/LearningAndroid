package com.example.assisgnmentdialoguebox

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assisgnmentdialoguebox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        var num=0;

        setContentView(binding.root)
        binding.q1.setOnClickListener{
            val dialog= AlertDialog.Builder(this)
            val array = arrayOf(".java",".kt",".xml",".kotlin")
            dialog.setTitle("What is extension used for saving Kotlin files?")

            dialog.setSingleChoiceItems(array, 0, DialogInterface.OnClickListener { dialog, which ->
                if (array[which] == ".kt") {
                    num += 4;
                } else {
                    num -= 1
                }
            })
            dialog.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                binding.a1.text = array[1]
            })
            dialog.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })
            dialog.show()
        }

        binding.q2.setOnClickListener{
            val dialog= AlertDialog.Builder(this)
            val array = arrayOf(".java",".kt",".xml",".kotlin")

            dialog.setTitle("What is extension used for saving java files?")
            dialog.setSingleChoiceItems(array, 0, DialogInterface.OnClickListener { dialog, which ->
                if (array[which] == ".java") {
                    num += 4;
                } else {
                    num -= 1
                }
            })
            dialog.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                binding.a2.text = array[0]
            })
            dialog.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })
            dialog.show()
        }


        binding.q3.setOnClickListener{
            val dialog= AlertDialog.Builder(this)
            val array = arrayOf("java","kotlin","python","swift")
            val selectedItems = ArrayList<Int>()

            dialog.setTitle("Which languages are used for Android Application Development?")
            dialog.setMultiChoiceItems(array, null, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                if (isChecked) {
                    selectedItems.add(which)
                    if (array[which] == "kotlin" || array[which] == "java") {
                        num += 2
                    }
                } else {
                    selectedItems.remove(Integer.valueOf(which))
                    if (array[which] == "kotlin" || array[which] == "java") {
                        num -= 2
                    }
                }
            })
            dialog.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, _ ->
                val selectedLanguages = selectedItems.joinToString(", ") { array[it] }
                binding.a3.text = "Selected languages: $selectedLanguages"
            })
            dialog.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, _ ->
                dialog.cancel()
            })
            dialog.show()
        }


        binding.q4.setOnClickListener{
            val dialog= AlertDialog.Builder(this)
            val array = arrayOf("Android App Development","Apple App Development","web development","Cloud Application Development")

            dialog.setTitle("What is the use of android studio?")
            dialog.setSingleChoiceItems(array, 16, DialogInterface.OnClickListener { dialog, which ->
                if (array[which] == "Android App Development") {
                    num += 4;
                } else {
                    num -= 1
                }
            })
            dialog.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                binding.a4.text = array[0]
            })
            dialog.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })
            dialog.show()
            binding.tview.text= "You have scored $num out of 12"
        }


    }
}