package com.example.recyclerapp

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class Adapter(data: ArrayList<Person>, internal var context: Context) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {


    // Step 2 : Create a constructor
    internal var data: List<Person>

    init {
        this.data = data
    }

    // Step 3 create the methods that we need
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout = LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = data[position].name
        holder.image.setImageResource(data[position].image)

        holder.card.setOnClickListener {
            val alert = Dialog(context)
            alert.setContentView(R.layout.alert)
            alert.window!!.setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY)
            alert.setTitle(data[position].name)

            var name = alert.findViewById<TextView>(R.id.alert_name)
            var telephone = alert.findViewById<TextView>(R.id.alert_telephone)
            var desc = alert.findViewById<TextView>(R.id.alert_desc)
            var image = alert.findViewById<ImageView>(R.id.alert_image)
            var call_btn = alert.findViewById<Button>(R.id.alert_call)

            name.text = data[position].name
            telephone.text = data[position].telephone
            image.setImageResource(data[position].image)
            desc.text = data[position].desc

            alert.show()

            call_btn.setOnClickListener {
                var intent =
                    Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", data[position].telephone, null))
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(context, intent, null)

                alert.dismiss()

            }

        }

    }

    override fun getItemCount(): Int {
        return data.size
    }


    // Step 1 Add view older
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var name: TextView
        internal var image: ImageView
        internal var card: CardView

        init {
            name = itemView.findViewById(R.id.profile_name)
            image = itemView.findViewById(R.id.profile_image)
            card = itemView.findViewById(R.id.card)
        }
    }
}