package com.example.politravel_cynthia_garca

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity()
{
    private var languages:Spinner?=null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lang: String
        val main = Intent(this, MainActivity::class.java)

        val continuar = findViewById<TextView>(R.id.continuar)
        val info = findViewById<ImageView>(R.id.info)
        languages = findViewById(R.id.spinner_language)

        val languagesList = arrayOf("", "Español", "Català", "English")
        var adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item, languagesList)

        languages?.adapter=adapter

        info.setOnClickListener {
            val intent = Intent(this, Info::class.java)
            startActivity(intent)
        }

        languages?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener
        {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when(position)
                {
                    1 ->
                    {
                        lang = "es"
                        setLocale(lang, "ES")
                        startActivity(main)
                    }
                    2 ->
                    {
                        lang = "ca"
                        setLocale(lang, "ES")
                        startActivity(main)
                    }
                    3 ->
                    {
                        lang = "en"
                        setLocale(lang, "rUS")
                        startActivity(main)
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        continuar.setOnClickListener{
            val intent = Intent(this, List::class.java)
            startActivity(intent)
        }

    }

    private fun setLocale(lang: String, loc: String)
    {
        val locale = Locale(lang, loc)
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }


}