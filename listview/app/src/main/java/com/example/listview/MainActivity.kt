package com.example.listview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items = ArrayList<CustomItem>()
        items.add(
            CustomItem(
                "Android Development",
                "Learn Android from scratch",
                R.drawable.sample
            )
        )
        items.add(CustomItem("Web Development", "Learn Android from scratch", R.drawable.image1))
        items.add(CustomItem("Web Design", "Learn Android from scratch", R.drawable.image2))
        items.add(CustomItem("Deep Learning", "Learn Android from scratch", R.drawable.image3))
        items.add(CustomItem("Code Python", "Learn Android from scratch", R.drawable.image4))
        items.add(CustomItem("Kotlin and Dart", "Learn Android from scratch", R.drawable.image5))
        items.add(CustomItem("C++ for beginners", "Learn Android from scratch", R.drawable.image6))

        val adapter = CustomAdapter(this@MainActivity, items)
        val listView = findViewById<ListView>(R.id.listView)

        listView.adapter = adapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                var alert = Dialog(this@MainActivity)
                alert.setContentView(R.layout.custom_alert)

                var title = alert.findViewById<TextView>(R.id.alertTitle)
                var desc = alert.findViewById<TextView>(R.id.alertDesc)
                var image = alert.findViewById<ImageView>(R.id.alertImage)
                var closeBtn = alert.findViewById<Button>(R.id.closeBtn)

                var item = adapter.getItem(position)

                title.text = item!!.title
                desc.text = item!!.desc
                image.setImageResource(item!!.image)

                alert.show()

                closeBtn.setOnClickListener {
                    alert.dismiss()
                }
            }
    }

}
