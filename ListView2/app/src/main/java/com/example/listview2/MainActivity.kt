package com.example.listview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items = ArrayList<CustomItem>()

        items.add(
            CustomItem(
                "Learn Programming",
                "This is the description of the title above",
                R.drawable.image1,
                R.drawable.image2
            )
        )
        items.add(
            CustomItem(
                "Python Programming",
                "This is the description of the title above",
                R.drawable.image3,
                R.drawable.image4
            )
        )
        items.add(
            CustomItem(
                "Android Programming",
                "This is the description of the title above",
                R.drawable.image5,
                R.drawable.image6
            )
        )
        items.add(
            CustomItem(
                "Web Development",
                "This is the description of the title above",
                R.drawable.image4,
                R.drawable.image1
            )
        )
        items.add(
            CustomItem(
                "Web Design",
                "This is the description of the title above",
                R.drawable.image5,
                R.drawable.image2
            )
        )
        items.add(
            CustomItem(
                "C++ Programming",
                "This is the description of the title above",
                R.drawable.image3,
                R.drawable.image6
            )
        )

        var adapter = ListAdapter(this@MainActivity, items)

        var listView = findViewById<ListView>(R.id.listView)

        listView.adapter = adapter
    }
}
