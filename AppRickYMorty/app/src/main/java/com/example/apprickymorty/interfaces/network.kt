package com.example.apprickymorty.interfaces

import com.example.apprickymorty.data.Personaje
import retrofit2.http.GET
import com.example.apprickymorty.data.PersonajeResponse
import com.example.apprickymorty.data.Ubicacion
import retrofit2.http.Path

//Consultas a la API
interface RickAndMortyApiService {
    @GET("character")
    suspend fun getPersonajes(): PersonajeResponse

    // Nuevo endpoint para obtener los detalles de un personaje por su ID
    @GET("character/{id}")
    suspend fun getPersonajeDetail(@Path("id") personajeId: String): Personaje

    @GET("location/{id}")
    suspend fun getUbicacion(@Path("id") ubicacionId: String): Ubicacion
}

