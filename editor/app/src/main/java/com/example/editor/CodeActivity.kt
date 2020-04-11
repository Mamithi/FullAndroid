package com.example.editor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView

class CodeActivity : AppCompatActivity() {

    lateinit var browser: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code)

        browser = findViewById(R.id.browser)
        browser.loadData(intent.getStringExtra("code"), "text/html; charset=utf-8", null)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater

        inflater.inflate(R.menu.code_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.enableJs -> {
                browser.settings.javaScriptEnabled

                return true
            }


        }

        return super.onOptionsItemSelected(item)
    }
}
