package com.example.politravel_cynthia_garca

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ItineraryAdapter (context: Context, val layout: Int, val itineraris: MutableList<Itinerary>) :
    ArrayAdapter<Itinerary>(context, layout, itineraris) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View

        if (convertView != null) {
            view = convertView
        } else {
            view = LayoutInflater.from(context).inflate(layout, parent, false)
        }

        bindPaquet(view, itineraris[position])

        return view
    }

    fun bindPaquet(view: View, itinerari: Itinerary) {
        val imgItinerary = view.findViewById<ImageView>(R.id.img_lst_itinerary)
        imgItinerary.setImageResource(itinerari.img)

        val itinerariName = view.findViewById<TextView>(R.id.name_lst_itinerary)
        itinerariName.text = itinerari.name
    }
}