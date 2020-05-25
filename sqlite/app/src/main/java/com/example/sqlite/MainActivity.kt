package com.example.sqlite

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var list: ArrayList<SubjectItem>
    lateinit var db: SqliteHelper
    lateinit var data: Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var go_subject = findViewById<Button>(R.id.go_subject)

        go_subject.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddSubjectActivity::class.java))
        }

        list = ArrayList<SubjectItem>()
        db = SqliteHelper(applicationContext)
        data = db.getData


        val adapter = SubjectAdapter(list, applicationContext)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)



        showData()

        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.adapter = adapter



    }

    fun showData() {
        if (data.count == 0) {
            Toast.makeText(applicationContext, "No Data!!!", Toast.LENGTH_SHORT).show()
        }

        while (data.moveToNext()) {
            list.add(SubjectItem(data.getString(0), data.getString(1), data.getString(2)))
        }
    }


    override fun onStart() {
        super.onStart()
        showData()
    }
}
