package com.example.apprickymorty.repository

import com.example.apprickymorty.data.Personaje
import com.example.apprickymorty.data.PersonajeResponse
import com.example.apprickymorty.data.Ubicacion
import com.example.apprickymorty.interfaces.RetrofitInstance

//Clase Repositorio
class PersonajeRepository: PersonajeRepositoryI {

    // Obtener todos los personajes
     override suspend fun getPersonajes(): PersonajeResponse {
        return RetrofitInstance.api.getPersonajes()
    }

    // Obtener detalles de un personaje por su ID
    override suspend fun getPersonajeDetail(personajeId: String): Personaje {
        return RetrofitInstance.api.getPersonajeDetail(personajeId)
    }

    //Obtener detalle de la ubicacion
   override suspend fun getUbicacion(ubicacionId: String): Ubicacion {
        return RetrofitInstance.api.getUbicacion(ubicacionId)
    }
}