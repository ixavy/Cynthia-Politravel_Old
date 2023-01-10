package com.example.politravel_cynthia_garca

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ItineraryEdit: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_llistat_itinerary)

        val itinerary = findViewById<ListView>(R.id.lst_itinerary)

        val intent = intent
        var itineraris: ArrayList<Itinerary> = intent.getSerializableExtra("Itinerary") as ArrayList<Itinerary>

        val adapter = ItineraryAdapter(this, R.layout.itinerary_item, itineraris)
        itinerary.adapter = adapter
    }
}