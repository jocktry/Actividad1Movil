package com.example.apprickymorty.data

//Clase Lista de Personajes
data class PersonajeResponse(
    val results: List<Personaje>
)

//Clase Personaje
data class Personaje(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String,
    val origin: LocationInfo,
    val location: LocationInfo
)

//Clase que mapea la informacion de la locacion que viaja
//en el Json del personaje
data class LocationInfo(
    val name: String,
    val url: String
)