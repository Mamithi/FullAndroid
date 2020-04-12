package com.example.libraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ncorti.slidetoact.SlideToActView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var slider = findViewById<SlideToActView>(R.id.slider)
        slider.onSlideCompleteListener = object : SlideToActView.OnSlideCompleteListener {
            override fun onSlideComplete(view: SlideToActView) {
                Toast.makeText(this@MainActivity, "Welcome", Toast.LENGTH_SHORT).show()
            }

        }


    }
}
