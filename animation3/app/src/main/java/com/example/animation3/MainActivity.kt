package com.example.animation3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imageView = findViewById<ImageView>(R.id.imageFade)
        var scaleBtn = findViewById<Button>(R.id.scaleBtn)
        var fadeBtn = findViewById<Button>(R.id.fadeBtn)

        scaleBtn.setOnClickListener {
            var animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.scale)
            imageView.startAnimation(animation)
        }

        fadeBtn.setOnClickListener {
            var animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.fade)
            imageView.startAnimation(animation)
        }
    }
}
