package com.example.understanrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit  var recyclerView: RecyclerView
    lateinit var newsArrayList:ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerView)
        val imageArray = arrayOf(R.drawable.my,R.drawable.pic1,R.drawable.pic2,R.drawable.pic3 )

        val newsHeading = arrayOf("My First News",
            "My Second News",
            "My Third News",
            "My Fourth News")

        recyclerView.layoutManager=LinearLayoutManager(this)
        newsArrayList= arrayListOf<News>()

        for(index in newsArrayList.indices){
            val news = News(newsHeading[index],imageArray[index])
            newsArrayList.add(news)
        }
        recyclerView.adapter=MyAdaoter(newsArrayList,this)
    }
}