package com.example.video

import android.app.Dialog
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.VideoView

class ListVideos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_videos)
    }

    fun imageClick(view: View) {
        val imageView = findViewById<View>(view.id)
        val alert = Dialog(this@ListVideos)
        alert.setContentView(R.layout.custom_video_alert)
        var videoAlert = alert.findViewById<VideoView>(R.id.videoAlert)
        var play = alert.findViewById<Button>(R.id.play)
        var pause = alert.findViewById<Button>(R.id.pause)
        var resume = alert.findViewById<Button>(R.id.resume)

        when (imageView.id) {
            R.id.image1 -> {
                var videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video1)
                videoAlert.setVideoURI(videoUri)

                alert.show()

                play.setOnClickListener {
                    videoAlert.start()
                }

                pause.setOnClickListener {
                    videoAlert.pause()
                }

                resume.setOnClickListener {
                    videoAlert.resume()
                }
            }

            R.id.image2 -> {
                var videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video2)
                videoAlert.setVideoURI(videoUri)

                alert.show()

                play.setOnClickListener {
                    videoAlert.start()
                }

                pause.setOnClickListener {
                    videoAlert.pause()
                }

                resume.setOnClickListener {
                    videoAlert.resume()
                }

            }

            R.id.image3 -> {
                var videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video3)
                videoAlert.setVideoURI(videoUri)

                alert.show()

                play.setOnClickListener {
                    videoAlert.start()
                }

                pause.setOnClickListener {
                    videoAlert.pause()
                }

                resume.setOnClickListener {
                    videoAlert.resume()
                }

            }

            R.id.image4 -> {
                var videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video4)
                videoAlert.setVideoURI(videoUri)

                alert.show()

                play.setOnClickListener {
                    videoAlert.start()
                }

                pause.setOnClickListener {
                    videoAlert.pause()
                }

                resume.setOnClickListener {
                    videoAlert.resume()
                }

            }
        }

    }
}
