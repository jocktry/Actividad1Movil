package com.example.apprickymorty.repository

import com.example.apprickymorty.data.Personaje
import com.example.apprickymorty.data.PersonajeResponse
import com.example.apprickymorty.data.Ubicacion

interface PersonajeRepositoryI {
    // Obtener todos los personajes
    suspend fun getPersonajes(): PersonajeResponse

    // Obtener detalles de un personaje por su ID
    suspend fun getPersonajeDetail(personajeId: String): Personaje

    // Obtener detalle de la ubicación
    suspend fun getUbicacion(ubicacionId: String): Ubicacion
}