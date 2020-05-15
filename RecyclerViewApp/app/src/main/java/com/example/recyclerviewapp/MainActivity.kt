package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items = ArrayList<CustomItem>()

        items.add(CustomItem("Cat", R.drawable.image1))
        items.add(CustomItem("Dog", R.drawable.image2))
        items.add(CustomItem("Mouse", R.drawable.image3))
        items.add(CustomItem("Hen", R.drawable.image4))
        items.add(CustomItem("Air", R.drawable.image5))
        items.add(CustomItem("Sky", R.drawable.image6))
        items.add(CustomItem("Cat", R.drawable.image1))
        items.add(CustomItem("Dog", R.drawable.image2))
        items.add(CustomItem("Mouse", R.drawable.image3))
        items.add(CustomItem("Hen", R.drawable.image4))
        items.add(CustomItem("Air", R.drawable.image5))
        items.add(CustomItem("Sky", R.drawable.image6))


        var recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        var adapter = CustomAdapter(items, applicationContext)

        recycler_view.layoutManager = GridLayoutManager(applicationContext, 2)
        recycler_view.adapter = adapter
    }
}
