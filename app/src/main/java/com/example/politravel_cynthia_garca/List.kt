package com.example.politravel_cynthia_garca

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class List: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_llistat)

        val lstPaquets = findViewById<ListView>(R.id.lst_paquets)

        var paquets: ArrayList<Paquet> = getPaquets()

        val adapter = PaquetAdapter(this, R.layout.paquets_item, paquets)
        lstPaquets.adapter = adapter

        lstPaquets.onItemClickListener = AdapterView.OnItemClickListener()
        {
            _, _, i, _ ->
            val intent = Intent(this, DetailPaquetActivity::class.java)
            intent.putExtra(DetailPaquetActivity.paquetConstants.PAQUET, paquets[i])
            startActivity(intent)
        }

    }

    fun getPaquets(): ArrayList<Paquet>
    {
        return arrayListOf(
            Paquet(0, resources.getString(R.string.disneyland),
                R.drawable.transp_avion,
                3,
                resources.getString(R.string.barcelona),
                resources.getString(R.string.francia),
                R.drawable.elprat,
                resources.getString(R.string.prat),
                R.drawable.disney,
                mutableListOf(
                    Itinerary(resources.getString(R.string.fantasyland), R.drawable.fantasyland),
                    Itinerary(resources.getString(R.string.adventureland), R.drawable.adventureland),
                    Itinerary(resources.getString(R.string.frontierland), R.drawable.frontierland))
            ),
            Paquet(1, resources.getString(R.string.harrypotter_londres),
                R.drawable.transp_avion,
                2,
                resources.getString(R.string.madrid),
                resources.getString(R.string.londres),
                R.drawable.barajas,
                resources.getString(R.string.barajas),
                R.drawable.harry_potter,
                mutableListOf(
                    Itinerary(resources.getString(R.string.warnerbros), R.drawable.warner_bros_studies),
                    Itinerary(resources.getString(R.string.harrypotter), R.drawable.reviving_harry_potter))
            ),
            Paquet(2, resources.getString(R.string.portaventura),
                R.drawable.transp_tren,
                1,
                resources.getString(R.string.barcelona),
                resources.getString(R.string.barcelona),
                R.drawable.sants,
                resources.getString(R.string.sants_estacio),
                R.drawable.port_aventura,
                mutableListOf(
                    Itinerary(resources.getString(R.string.mediterrania), R.drawable.mediterrania_port_aventura),
                    Itinerary(resources.getString(R.string.furius_baco), R.drawable.furius_baco))
            ),
            Paquet(3, resources.getString(R.string.roma_express),
                R.drawable.transp_barco,
                4,
                resources.getString(R.string.francia),
                resources.getString(R.string.roma),
                R.drawable.portvell,
                resources.getString(R.string.port_vell),
                R.drawable.rome,
                mutableListOf(
                    Itinerary(resources.getString(R.string.museos_vaticanos), R.drawable.vatican_museum),
                    Itinerary(resources.getString(R.string.capilla_sixtina), R.drawable.sistine_chapel))
            ),
            Paquet(4, resources.getString(R.string.tina_turner),
                R.drawable.transp_tren,
                1,
                resources.getString(R.string.barcelona),
                resources.getString(R.string.madrid),
                R.drawable.sants,
                resources.getString(R.string.sants_estacio),
                R.drawable.tina_turner_musical,
                mutableListOf(
                    Itinerary(resources.getString(R.string.plaza_mayor), R.drawable.plaza_mayor),
                    Itinerary(resources.getString(R.string.mercado), R.drawable.mercat_de_san_miquel),
                    Itinerary(resources.getString(R.string.palacio), R.drawable.palacio_real)))
        )
    }
}
