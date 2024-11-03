package com.example.apprickymorty.repository

import com.example.apprickymorty.data.PersonajeResponse
import com.example.apprickymorty.interfaces.RetrofitInstance
class PersonajeRepository {
    suspend fun getPersonajes(): PersonajeResponse {
        return RetrofitInstance.api.getPersonajes()
    }
}