package com.example.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(data: ArrayList<CustomItem>, var context: Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    var data: List<CustomItem>

    init {
        this.data = data
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.image.setImageResource(data[position].image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout = LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false)
        return ViewHolder(layout)
    }


    override fun getItemCount(): Int {
        return data.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var image: ImageView

        init {
            title = itemView.findViewById(R.id.item_title)
            image = itemView.findViewById(R.id.item_image)
        }
    }
}