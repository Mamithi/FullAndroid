package com.example.video

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

class SingleVideo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_video)


        var videoPlayer = findViewById<VideoView>(R.id.videoPlayer)
        var playBtn = findViewById<Button>(R.id.playBtn)
        var pauseBtn = findViewById<Button>(R.id.pauseBtn)

        var videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video1)
        videoPlayer.setVideoURI(videoUri)

        playBtn.setOnClickListener {
            videoPlayer.start()
        }

        pauseBtn.setOnClickListener {
            videoPlayer.pause()
        }
    }
}
