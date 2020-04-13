package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class CustomAdapter(context: Context, data: ArrayList<CustomItem>) :
    ArrayAdapter<CustomItem>(context, 0, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        itemView = LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false)

        var item = getItem(position)

        var title = itemView!!.findViewById<TextView>(R.id.itemTitle)
        title.text = item!!.title

        var desc = itemView!!.findViewById<TextView>(R.id.itemDesc)
        desc.text = item!!.desc

        var image = itemView!!.findViewById<ImageView>(R.id.itemImage)
        image.setImageResource(item!!.image)

        return itemView
    }
}