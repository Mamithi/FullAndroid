package com.example.video

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var videoBtn = findViewById<Button>(R.id.videoBtn)
        var listVideos = findViewById<Button>(R.id.listVideos)

        videoBtn.setOnClickListener {
            var intent = Intent(this@MainActivity, SingleVideo::class.java)
            startActivity(intent)
        }

        listVideos.setOnClickListener {
            var intent = Intent(this@MainActivity, ListVideos::class.java)
            startActivity(intent)
        }
    }
}
