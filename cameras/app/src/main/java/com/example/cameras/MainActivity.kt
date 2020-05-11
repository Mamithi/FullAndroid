package com.example.cameras

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.VideoView
import hb.xvideoplayer.MxTvPlayerWidget
import hb.xvideoplayer.MxVideoPlayer
import hb.xvideoplayer.MxVideoPlayerWidget

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Play video from  url
        val videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
        var videoUri = Uri.parse(videoUrl)
        var videoPlayer = findViewById<MxTvPlayerWidget>(R.id.videoPlayer)

        videoPlayer.startPlay(videoUrl, "video name")




        // Rate a page
        var rateBtn = findViewById<Button>(R.id.rateBtn)

        rateBtn.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=$packageName")
                    )
                )
            } catch (error: android.content.ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    )
                )
            }
        }


        // Send a message
        var sendBtn = findViewById<Button>(R.id.sendBtn)

        sendBtn.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + 56788766)))


//            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+56788766))
//            intent.putExtra("sms_body", "Hello Bro")
//            startActivity(intent)
        }


        // Making a call
        var callBtn = findViewById<Button>(R.id.callBtn)

        callBtn.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "100", null)))
        }


        // Taking a picture
        var openBtn = findViewById<Button>(R.id.openBtn)

        openBtn.setOnClickListener {
            //            var intent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)


            var intent = Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(intent, 111)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 111) {
//            var image = data!!.extras!!.get("data") as Bitmap
//            var imageGallery = findViewById<ImageView>(R.id.imageGallery)
//
//            imageGallery.setImageBitmap(image)


            if (data != null) {
                var imageUri = data.data
                var imageGallery = findViewById<ImageView>(R.id.imageGallery)
                imageGallery.setImageURI(imageUri)
            }
        }
    }
}
