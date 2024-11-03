package com.example.apprickymorty

import com.example.apprickymorty.data.LocationInfo
import com.example.apprickymorty.data.Personaje
import com.example.apprickymorty.data.PersonajeResponse
import com.example.apprickymorty.data.Ubicacion
import com.example.apprickymorty.repository.PersonajeRepositoryI

class FakeApiData : PersonajeRepositoryI {


    // Simula la recuperación de personajes
    override suspend fun getPersonajes(): PersonajeResponse {
        val locationInfo = LocationInfo(name = "", url = "")
        val personajes = listOf(
            Personaje(id = 1, name = "Rick", image = "img.png", status = "Dead", species = "Human", origin = locationInfo, location = locationInfo),
            Personaje(id = 2, name = "Morty", image = "img.png", status = "Dead", species = "Human", origin = locationInfo, location = locationInfo)
        )
        return PersonajeResponse(results = personajes)
    }

    override suspend fun getPersonajeDetail(personajeId: String): Personaje {
        TODO("Not yet implemented")
    }

    override suspend fun getUbicacion(ubicacionId: String): Ubicacion {
        TODO("Not yet implemented")
    }

}