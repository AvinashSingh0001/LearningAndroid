package com.example.listviewadvanced

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val name= arrayOf("Saumya", "Parful", "Avinash", "Pratap")

        val lastMsg= arrayOf("Hey Whatsup.", "I am fine.", "I am working android Studio project.","What is the update on project.")

        val lastMsgTime = arrayOf("6:25 PM","4:45 PM","6:30 PM","1:20 PM" )

        val phonenumber= arrayOf("97868686","98456123", "984532987","981239087")

        val imgId= intArrayOf(R.drawable.pic3,R.drawable.pic2,R.drawable.my,R.drawable.pic1)

         userArrayList= ArrayList()

        for (eachindex in name.indices){
            val user= User(name[eachindex],lastMsg[eachindex],lastMsgTime[eachindex],phonenumber[eachindex], imgId[eachindex])
            userArrayList.add(user)
        }

        val listView=findViewById<ListView>(R.id.listview)
        listView.isClickable= true

        listView.adapter=MyAdapter(this,userArrayList)


    }
}