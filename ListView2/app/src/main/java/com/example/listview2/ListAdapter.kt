package com.example.listview2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(context: Context, data: ArrayList<CustomItem>) :
    ArrayAdapter<CustomItem>(context, 0, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView

        itemView = LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false)

        var item = getItem(position)

        var title = itemView.findViewById<TextView>(R.id.title)
        var desc = itemView.findViewById<TextView>(R.id.desc)
        var imageOne = itemView.findViewById<ImageView>(R.id.imageOne)
        var imageTwo = itemView.findViewById<ImageView>(R.id.imageTwo)

        title.text = item!!.itemTitle
        desc.text = item!!.itemDesc
        imageOne.setImageResource(item!!.imageOne)
        imageTwo.setImageResource(item!!.imageTwo)

        return itemView
    }
}