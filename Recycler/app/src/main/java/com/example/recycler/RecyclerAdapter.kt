package com.example.recycler

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.core.app.ActivityCompat.startActivityForResult
import android.provider.Settings
import android.content.Intent


class RecyclerAdapter(data: ArrayList<CustomItem>, internal var context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    internal var data: List<CustomItem>

    init {
        this.data = data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.image.setImageResource(data[position].image)
        holder.card.setOnClickListener {
            var alert = Dialog(context)
            alert.setContentView(R.layout.alert)


//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                alert.window!!.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT)
//            } else {
//                alert.window!!.setType(WindowManager.LayoutParams.TYPE_PHONE)
//            }


            alert.window!!.setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY)
            alert.setTitle("Android Development")

            var alertTitle = alert.findViewById<TextView>(R.id.alertTitle)
            var alertImage = alert.findViewById<ImageView>(R.id.alertImage)
            var alertBtn = alert.findViewById<Button>(R.id.doneBtn)

            alertTitle.text = data[position].title
            alertImage.setImageResource(data[position].image)


            alert.show()



            alertBtn.setOnClickListener {
                alert.dismiss()
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var title: TextView
        internal var image: ImageView
        internal var card: CardView

        init {
            title = itemView.findViewById(R.id.itemTitle)
            image = itemView.findViewById(R.id.itemImage)
            card = itemView.findViewById(R.id.card)
        }

    }
}