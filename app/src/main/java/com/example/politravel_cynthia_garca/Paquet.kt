package com.example.politravel_cynthia_garca

import java.io.Serializable

class Paquet (var id: Int, var name: String, var transportation: Int, var days: Int, var origin: String, var destiny: String, var startPointImg: Int, var startingPoint: String, val img: Int, val itinerary: MutableList<Itinerary>):
    Serializable