package com.example.editor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AutoCompleteTextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var userCode: AutoCompleteTextView
    lateinit var runBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userCode = findViewById(R.id.userCode)
        runBtn = findViewById(R.id.runBtn)

        runBtn.setOnClickListener {
            run()
        }
    }

    private fun run() {
        var intent = Intent(this@MainActivity, CodeActivity::class.java)
        intent.putExtra("code", userCode.text.toString())
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater

        inflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.runCode -> {
                run()
                return true
            }

            R.id.addCode -> {
                userCode.setText(
                    "<!DOCTYPE html>\n" +
                            "<html>\n" +
                            "<body>\n" +
                            "\n" +
                            "<h1>My First Heading</h1>\n" +
                            "\n" +
                            "<p>My first paragraph.</p>\n" +
                            "\n" +
                            "</body>\n" +
                            "</html>\n"
                )

                return true

            }

            R.id.clear -> {
                userCode.setText("")
                return true

            }

            R.id.close -> {
                finish()
                return true

            }

        }

        return super.onOptionsItemSelected(item)
    }
}
