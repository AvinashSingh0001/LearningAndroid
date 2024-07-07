package com.example.viewbinding

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.viewbinding.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding   // this ActivityMainBinding class is generated by the studio from where without creating findviewid i can use any view
                                               //  or button to perform action.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)      // this is used for inflating all the layout vies.
        setContentView(binding.root)                            // calling the root of finding class

        binding.btn.setOnClickListener {        // way of calling from xml directly by id
            if (binding.cb.isChecked) {                // CONCEPT: the check box used is controlled frm here.
                binding.newTextView.text =
                    "Contratulations, You have understand about binding class. Now proceed further for next goal."
            }else{
                binding.cb.buttonTintList= ColorStateList.valueOf(Color.RED)
                Toast.makeText(this,"Please check the checkbox,",Toast.LENGTH_SHORT).show()
            }
        }
    }
}