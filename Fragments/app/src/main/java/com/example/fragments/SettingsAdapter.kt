package com.example.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class SettingsAdapter(data: ArrayList<SettingClass>, var context: Context) :
    RecyclerView.Adapter<SettingsAdapter.ViewHolder>() {


    var data: List<SettingClass>

    init {
        this.data = data
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(data[position].image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout = LayoutInflater.from(context).inflate(R.layout.settings_item, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: CircleImageView

        init {
            image = itemView.findViewById(R.id.settings_image)
        }

    }
}