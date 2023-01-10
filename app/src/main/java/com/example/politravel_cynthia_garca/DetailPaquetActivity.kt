package com.example.politravel_cynthia_garca

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import org.w3c.dom.Text

class DetailPaquetActivity: AppCompatActivity()
{
    object paquetConstants{
        const val PAQUET = "PAQUET"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_detall)

        val intent = intent
        val paquet: Paquet = intent.getSerializableExtra(paquetConstants.PAQUET) as Paquet

        val img = findViewById<ImageView>(R.id.paquet_img)
        img.setImageResource(paquet.img)

        val name = findViewById<TextView>(R.id.paquet_name)
        name.text = paquet.name

        val days = findViewById<TextView>(R.id.paquet_days)
        days.text = paquet.days.toString() + " " + resources.getString(R.string.dias)

        val origin = findViewById<TextView>(R.id.paquet_origin)
        origin.text = paquet.origin

        val destiny = findViewById<TextView>(R.id.paquet_destiny)
        destiny.text = paquet.destiny

        val transport = findViewById<ImageView>(R.id.paquet_transport)
        transport.setImageResource(paquet.transportation)

        val imgOrigin = findViewById<ImageView>(R.id.img_origin)
        imgOrigin.setImageResource(paquet.startPointImg)

        val puntoPartida = findViewById<TextView>(R.id.paquet_punto_partida)
        puntoPartida.text = paquet.startingPoint

        val edit = findViewById<ImageView>(R.id.edit)

        val itinerary = findViewById<TextView>(R.id.itinerary)
        var itineraris: ArrayList<Itinerary> = paquet.itinerary as ArrayList<Itinerary>

        itinerary.setOnClickListener(){
            val intent = Intent(this, ItinerayList::class.java)
            intent.putExtra("Itinerary", itineraris)
            startActivity(intent)
        }

        edit.setOnClickListener{
            val intent = Intent(this, PaquetEdit::class.java)
            intent.putExtra(paquetConstants.PAQUET, paquet)
            startActivity(intent)
        }
    }
}