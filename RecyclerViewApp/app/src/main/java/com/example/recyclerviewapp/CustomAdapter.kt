package com.example.recyclerviewapp

import android.app.Dialog
import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class CustomAdapter(data: ArrayList<CustomItem>, var context: Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    // Step 2 : Create a constructor
    var data: List<CustomItem>

    init {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout = LayoutInflater.from(context).inflate(R.layout.item, parent, false)

        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = data[position].name
        holder.image.setImageResource(data[position].image)
        holder.card.setOnClickListener {
            var alert = Dialog(context)
            alert.setContentView(R.layout.alert)
            alert.window!!.setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY)


            var alert_name = alert.findViewById<TextView>(R.id.alert_name)
            var alert_image = alert.findViewById<ImageView>(R.id.alert_image)
            var spell_btn = alert.findViewById<Button>(R.id.spell_btn)
            var done_btn = alert.findViewById<Button>(R.id.done_btn)

            alert_name.text = data[position].name
            alert_image.setImageResource(data[position].image)

            alert.show()

            spell_btn.setOnClickListener {
                holder.text_to_speech =
                    TextToSpeech(context, TextToSpeech.OnInitListener { status ->
                        if (status == TextToSpeech.SUCCESS) {
                            holder.text_to_speech.language = Locale.UK
                            holder.text_to_speech.speak(
                                data[position].name,
                                TextToSpeech.QUEUE_FLUSH,
                                null,
                                null
                            )
                        }

                    })
            }

            done_btn.setOnClickListener {
                alert.dismiss()
            }


        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    // Step 1 : Create a view holder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var image: ImageView
        var card: CardView
        lateinit var text_to_speech: TextToSpeech

        init {
            name = itemView.findViewById(R.id.item_name)
            image = itemView.findViewById(R.id.item_image)
            card = itemView.findViewById(R.id.card)
        }
    }
}
