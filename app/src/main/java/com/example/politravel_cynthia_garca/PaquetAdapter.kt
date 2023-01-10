package com.example.politravel_cynthia_garca

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class PaquetAdapter(context: Context, val layout: Int, val paquets: MutableList<Paquet>) :
    ArrayAdapter<Paquet>(context, layout, paquets)
{
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
        {
            var view: View

            if(convertView != null)
            {
                view = convertView
            }
            else
            {
                view = LayoutInflater.from(context).inflate(layout, parent, false)
            }

            bindPaquet(view, paquets[position])
            
            return view
        }

    fun bindPaquet(view: View, paquet: Paquet)
    {
        val imgPaquet = view.findViewById<ImageView>(R.id.img_lst_paquet)
        imgPaquet.setImageResource(paquet.img)

        val paquetName = view.findViewById<TextView>(R.id.name_lst)
        paquetName.text = paquet.name

        val transport = view.findViewById<ImageView>(R.id.transport_lst)
        transport.setImageResource(paquet.transportation)

        val days = view.findViewById<TextView>(R.id.days_lst)
        days.text = paquet.days.toString()
    }
}
