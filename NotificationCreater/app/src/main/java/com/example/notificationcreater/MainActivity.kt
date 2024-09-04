package com.example.notificationcreater

import android.Manifest

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
 private val CHANNELID= "channelId"
   private val CHANNELNAME= "No Internet"
    val notificationId=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button= findViewById<Button>(R.id.button)
        val button1= findViewById<Button>(R.id.button2)
       createNotificationChannel()

        //Pending intent
                      // run when user click on the notification to open the app specific part at the time of clicking the notification.
        val intent= Intent(this,MainActivity::class.java)
        val pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_MUTABLE)

        // request Code is ued to differentiate between different pending Intent and flag is used to change the intent content


    val notification = NotificationCompat.Builder(this,CHANNELID)
        .setContentTitle("Internet not working")
        .setContentText("This Network has been gone, request you to come in  network coverage area for smooth experience.")
        .setSmallIcon(R.drawable.baseline_insert_emoticon_24)
        .setPriority(NotificationCompat.PRIORITY_HIGH) // problem- when already defined in channel that what is the need here.
        .setWhen(System.currentTimeMillis())
        .setContentIntent(pendingIntent)
        .build()

        val notification2 = NotificationCompat.Builder(this,CHANNELID)
            .setContentTitle("Internet not working")
            .setContentText(" i am second.")
            .setSmallIcon(R.drawable.baseline_insert_emoticon_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH) // problem- when already defined in channel that what is the need here.
            .setWhen(System.currentTimeMillis())
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager= NotificationManagerCompat.from(this)

        button.setOnClickListener{
            if (ActivityCompat.checkSelfPermission(    //checking for the permission
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                val NOTIFICATION_PERMISSION_REQUEST_CODE =65;
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    NOTIFICATION_PERMISSION_REQUEST_CODE // Define a request code
                )
            }
            notificationManager.notify(notificationId,notification)
            button1.setOnClickListener {
                notificationManager.notify(0,notification2)
            }
        }
        }


    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel= NotificationChannel(CHANNELID,CHANNELNAME,NotificationManager.IMPORTANCE_DEFAULT).apply{
               description ="You internet connection has been lost."
             //   lightColor= Color.GREEN    // changes the light of the screen to green when notification arrives.
             //   enableLights(true)
            }
            val channel2= NotificationChannel("channelId2","Delivery Update",NotificationManager.IMPORTANCE_HIGH).apply{
                description ="This is will help you to give update on the order reach."
                //   lightColor= Color.GREEN    // changes the light of the screen to green when notification arrives.
                //   enableLights(true)
            }
            val manager= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager  //narrow casting
            manager.createNotificationChannels(listOf(channel,channel2))
            //manager.createNotificationChannel(channel)

        }
    }


}