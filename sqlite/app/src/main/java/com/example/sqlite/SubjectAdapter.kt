package com.example.sqlite

import android.content.Context
import android.content.Intent.getIntent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class SubjectAdapter(data: ArrayList<SubjectItem>, var context: Context) :
    RecyclerView.Adapter<SubjectAdapter.ViewHolder>() {


    var data: List<SubjectItem>

    init {
        this.data = data
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = data[position].id
        holder.title.text = data[position].title
        holder.desc.text = data[position].desc


        holder.delete_btn.setOnClickListener {
            var db = SqliteHelper(context)
            db.deleteData(data[position].id.toString())
            Toast.makeText(context, data[position].title+" deleted successfully.", Toast.LENGTH_SHORT).show()


        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout = LayoutInflater.from(context).inflate(R.layout.item_subject, parent, false)
        return ViewHolder(layout)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id: TextView
        var title: TextView
        var desc: TextView
        var delete_btn: Button

        init {
            id = itemView.findViewById(R.id.id_textview)
            title = itemView.findViewById(R.id.title_textview)
            desc = itemView.findViewById(R.id.desc_textview)
            delete_btn = itemView.findViewById(R.id.delete_btn)
        }
    }
}