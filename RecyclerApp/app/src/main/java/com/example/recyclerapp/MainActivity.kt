package com.example.recyclerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var items = ArrayList<Person>()

        items.add(
            Person(
                "John Doe",
                "A Very good developer in android and web",
                "+254456761",
                R.drawable.image1
            )
        )
        items.add(
            Person(
                "Rob Reiner",
                "A Very good developer in android and web",
                "+254456761",
                R.drawable.image2
            )
        )
        items.add(
            Person(
                "Rob Reiner",
                "A Very good developer in android and web",
                "+254456761",
                R.drawable.image3
            )
        )
        items.add(
            Person(
                "Rob Reiner",
                "A Very good developer in android and web",
                "+254456761",
                R.drawable.image4
            )
        )
        items.add(
            Person(
                "Rob Reiner",
                "A Very good developer in android and web",
                "+254456761",
                R.drawable.image5
            )
        )
        items.add(
            Person(
                "Rob Reiner",
                "A Very good developer in android and web",
                "+254456761",
                R.drawable.image6
            )
        )
        items.add(
            Person(
                "Rob Reiner",
                "A Very good developer in android and web",
                "+254456761",
                R.drawable.image1
            )
        )
        items.add(
            Person(
                "Rob Reiner",
                "A Very good developer in android and web",
                "+254456761",
                R.drawable.image2
            )
        )
        items.add(
            Person(
                "Rob Reiner",
                "A Very good developer in android and web",
                "+254456761",
                R.drawable.image3
            )
        )
        items.add(
            Person(
                "Rob Reiner",
                "A Very good developer in android and web",
                "+254456761",
                R.drawable.image4
            )
        )
        items.add(
            Person(
                "Rob Reiner",
                "A Very good developer in android and web",
                "+254456761",
                R.drawable.image5
            )
        )
        items.add(
            Person(
                "Rob Reiner",
                "A Very good developer in android and web",
                "+254456761",
                R.drawable.image6
            )
        )


        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = Adapter(items, applicationContext)

        recycler_view.layoutManager = GridLayoutManager(applicationContext, 2)
        recycler_view.adapter = adapter
    }
}
