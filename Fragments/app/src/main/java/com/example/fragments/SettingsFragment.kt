package com.example.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var layout = inflater.inflate(R.layout.fragment_settings, container, false)

        var items = ArrayList<SettingClass>()

        items.add(SettingClass(R.drawable.image1))
        items.add(SettingClass(R.drawable.image2))
        items.add(SettingClass(R.drawable.image3))
        items.add(SettingClass(R.drawable.image4))
        items.add(SettingClass(R.drawable.image5))
        items.add(SettingClass(R.drawable.image6))
        items.add(SettingClass(R.drawable.image1))
        items.add(SettingClass(R.drawable.image2))
        items.add(SettingClass(R.drawable.image3))
        items.add(SettingClass(R.drawable.image4))
        items.add(SettingClass(R.drawable.image5))
        items.add(SettingClass(R.drawable.image6))


        var recyclerView = layout.findViewById<RecyclerView>(R.id.settings_list)

        var adapter = SettingsAdapter(items, activity!!.applicationContext)
        recyclerView.layoutManager = GridLayoutManager(activity!!.applicationContext, 2)

        recyclerView.adapter = adapter

        return layout
    }


}
