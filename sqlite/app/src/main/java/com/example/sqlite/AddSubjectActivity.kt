package com.example.sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddSubjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_subject)

        val db = SqliteHelper(applicationContext)
        var title_input = findViewById<EditText>(R.id.title_edit_text)
        var desc_input = findViewById<EditText>(R.id.desc_edit_text)
        var add_btn = findViewById<Button>(R.id.add_btn)

        add_btn.setOnClickListener {
            val title_text = title_input.text.toString().trim()
            val desc_text = desc_input.text.toString().trim()

            db.addData(title_text, desc_text)
            Toast.makeText(this@AddSubjectActivity, "Data saved successfully", Toast.LENGTH_SHORT)
                .show()

            startActivity(Intent(this@AddSubjectActivity, MainActivity::class.java))
        }

        var delete_btn = findViewById<Button>(R.id.delete_btn)

        delete_btn.setOnClickListener {
            Toast.makeText(applicationContext, "Button clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
