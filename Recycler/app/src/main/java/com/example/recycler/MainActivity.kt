package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items = ArrayList<CustomItem>()

        items.add(CustomItem("Android App", R.drawable.image1))
        items.add(CustomItem("Python Language", R.drawable.image2))
        items.add(CustomItem("Learn Kotlin", R.drawable.image3))
        items.add(CustomItem("Java Programming", R.drawable.image4))
        items.add(CustomItem("C++ From Scratch", R.drawable.image5))
        items.add(CustomItem("Love Javascript", R.drawable.image6))


        var recycler = findViewById<RecyclerView>(R.id.recyclerData)
        var adapter = RecyclerAdapter(items, applicationContext)

        recycler.layoutManager = GridLayoutManager(applicationContext, 3)
        recycler.adapter = adapter
    }
}
