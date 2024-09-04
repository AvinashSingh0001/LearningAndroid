package com.example.bottomnavigationview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bottomView = findViewById<BottomNavigationView>(R.id.bottomView)

        replaceWithFragment(Home())
        
        bottomView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item1-> replaceWithFragment(Home())
                R.id.item2 -> replaceWithFragment(search())
                R.id.item3 -> replaceWithFragment(Profile())
                else-> {

                }
            }
            true
        }
    }

    private fun replaceWithFragment(fragment: Fragment) {

        val fragmentManager= supportFragmentManager
        val fragmentTransition= fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frameLayout, fragment)
        fragmentTransition.commit()
    }
}