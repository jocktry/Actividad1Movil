package com.example.apprickymorty.interfaces

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import com.example.apprickymorty.data.PersonajeResponse

interface RickAndMortyApiService {
    @GET("character")
    suspend fun getPersonajes(): PersonajeResponse
}

