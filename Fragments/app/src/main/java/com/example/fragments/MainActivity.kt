package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nav = findViewById<BottomNavigationView>(R.id.nav)
        val frame_layout = findViewById<FrameLayout>(R.id.frame_layout)

        var game = posts()
        var web = UserFragment()
        var android = SettingsFragment()


        var fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.frame_layout, game)
        fragment.commit()

        nav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.game_icon -> {
                    var fragment = supportFragmentManager.beginTransaction()
                    fragment.replace(R.id.frame_layout, game)
                    fragment.commit()

                    true
                }

                R.id.web_icon -> {
                    var fragment = supportFragmentManager.beginTransaction()
                    fragment.replace(R.id.frame_layout, web)
                    fragment.commit()

                    true
                }

                R.id.android_icon -> {
                    var fragment = supportFragmentManager.beginTransaction()
                    fragment.replace(R.id.frame_layout, android)
                    fragment.commit()

                    true
                }

                else -> false
            }

        }
    }
}
