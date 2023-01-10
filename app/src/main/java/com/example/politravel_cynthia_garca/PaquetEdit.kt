package com.example.politravel_cynthia_garca

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PaquetEdit : AppCompatActivity()
{
    private var transports:Spinner?=null
    private lateinit var imgPaquet: ImageView
    private lateinit var imageUri: Uri
    private val PICK_IMAGE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paquet_edit)

        val intent = intent
        val paquet: Paquet = intent.getSerializableExtra(DetailPaquetActivity.paquetConstants.PAQUET) as Paquet

        val namePaquet = findViewById<EditText>(R.id.paquet_name)
        namePaquet.hint = paquet.name

        val daysPaquet = findViewById<EditText>(R.id.paquet_days)
        daysPaquet.hint = paquet.days.toString() + " " + resources.getString(R.string.dias)

        val origin = findViewById<EditText>(R.id.paquet_origin)
        origin.hint = paquet.origin

        val destiny = findViewById<EditText>(R.id.paquet_destiny)
        destiny.hint = paquet.destiny

        val transport = findViewById<ImageView>(R.id.paquet_transport)
        transport.setImageResource(paquet.transportation)

        val imgOrigin = findViewById<ImageView>(R.id.img_origin)
        imgOrigin.setImageResource(paquet.startPointImg)

        val puntoPartida = findViewById<EditText>(R.id.paquet_punto_partida)
        puntoPartida.hint = paquet.startingPoint

        val pickImgOrigin = findViewById<ImageView>(R.id.new_img_paquet)

        val pickImg = findViewById<ImageView>(R.id.new_img_paquet)

        transports = findViewById(R.id.spinner_transport)

        val transportsList = arrayOf("", resources.getString(R.string.avio), resources.getString(R.string.tren), resources.getString(R.string.vaixell))
        var adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, transportsList)

        transports?.adapter=adapter

        imgPaquet = findViewById(R.id.paquet_img)
        imgPaquet.setImageResource(paquet.img)

        transports?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    1 -> {
                        transport.setImageResource(R.drawable.transp_avion)
                    }
                    2 -> {
                        transport.setImageResource(R.drawable.transp_tren)
                    }
                    3 -> {
                        transport.setImageResource(R.drawable.transp_barco)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        pickImgOrigin.setOnClickListener{
            openGallery()
        }

        pickImg.setOnClickListener{
            openGallery()
        }

        val guardarPaquet = findViewById<Button>(R.id.guardar_paquet)

        guardarPaquet.setOnClickListener{
            if(namePaquet.text != null){
                paquet.name = namePaquet.text.toString()
            }
            if(transport.id != null) {
                paquet.transportation = transport.id
            }
            if(puntoPartida.text != null){
                paquet.startingPoint = puntoPartida.text.toString()
            }
            if(daysPaquet.text != null){
                paquet.days = Integer.parseInt(daysPaquet.text.toString())
            }
            if(origin.text != null){
                paquet.origin = origin.text.toString()
            }
            if(destiny.text != null){
                paquet.destiny = destiny.text.toString()
            }
            if(imgOrigin.id != null){
                paquet.startPointImg = imgOrigin.id
            }
            if(transport.id != null){
                paquet.transportation = transport.id
            }
            if(puntoPartida.text != null){
                paquet.startingPoint = puntoPartida.text.toString()
            }
            val list = List()
            var paquets: MutableList<Paquet> = list.getPaquets()

            val i: Int = searchPaquet(paquets)
            if(i > -1){
                paquets[i] = paquet
            }
            else
            {
                Toast.makeText(this,"An error has occurred", Toast.LENGTH_LONG)
            }

        }

        val borrar = findViewById<Button>(R.id.borrar_paquet)
        borrar.setOnClickListener{
            val list = List()
            var paquets: MutableList<Paquet> = list.getPaquets()
            val i = searchPaquet(paquets)
            if(i > -1){
                paquets.removeAt(i)
            }
            else
            {
                Toast.makeText(this,"An error has occurred", Toast.LENGTH_LONG)
            }
        }
    }

    fun openGallery(){
        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, PICK_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            if (data != null) {
                imageUri = data.data!!
            }
            imgPaquet.setImageURI(imageUri)
        }
    }

    fun searchPaquet(paquets: MutableList<Paquet>): Int{
        var i = 0
        var correct:Boolean

        do{
            correct = i == paquets[i].id
            i++
        }while(!correct && i < paquets.size)

        if(!correct){
            i = -1
        }

        return i
    }
}