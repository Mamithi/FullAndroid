package com.example.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class posts : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var layout = inflater.inflate(R.layout.fragment_posts, container, false)

        val items = ArrayList<CustomItem>()

        items.add(CustomItem("Android Development", R.drawable.image1))
        items.add(CustomItem("Python Development", R.drawable.image2))
        items.add(CustomItem("Deno Development", R.drawable.image3))
        items.add(CustomItem("Node Development", R.drawable.image4))
        items.add(CustomItem("Text Development", R.drawable.image5))
        items.add(CustomItem("Good Development", R.drawable.image6))
        items.add(CustomItem("Android Development", R.drawable.image1))
        items.add(CustomItem("Python Development", R.drawable.image2))
        items.add(CustomItem("Deno Development", R.drawable.image3))
        items.add(CustomItem("Node Development", R.drawable.image4))
        items.add(CustomItem("Text Development", R.drawable.image5))
        items.add(CustomItem("Good Development", R.drawable.image6))


        var recyclerView = layout.findViewById<RecyclerView>(R.id.posts_list)

        var adapter = CustomAdapter(items, activity!!.applicationContext)

        recyclerView.layoutManager = GridLayoutManager(activity!!.applicationContext, 2)

        recyclerView.adapter = adapter




        return layout
    }


}
