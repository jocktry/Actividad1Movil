package com.example.apprickymorty.interfaces

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Configuracion Consulta API
object RetrofitInstance {
    val api: RickAndMortyApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyApiService::class.java)
    }
}