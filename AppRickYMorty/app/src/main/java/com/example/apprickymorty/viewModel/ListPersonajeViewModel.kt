package com.example.apprickymorty.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apprickymorty.data.Personaje
import com.example.apprickymorty.data.Ubicacion
import com.example.apprickymorty.repository.PersonajeRepositoryI
import kotlinx.coroutines.launch

class ListPersonajeViewModel(private val repository: PersonajeRepositoryI): ViewModel() {
    //Variable en memoria que almacena la lista de personajes
    private val _personajes:MutableState<List<Personaje>> = mutableStateOf(emptyList())
    //Variable publica observable
    val personajesVM: State<List<Personaje>> = _personajes
    //Lista de personajes filtrados, para el elemento outlinedtext
    val personajesFiltered = mutableStateOf<List<Personaje>>(emptyList())

    //Variable para el detalle de un personaje
    private val _personajeDetail: MutableState<Personaje?> = mutableStateOf(null)
    val personajeDetail: State<Personaje?> = _personajeDetail

    //Variables para la ubicacion de un personaje
    private val _ubicacionDetail: MutableState<Ubicacion?> = mutableStateOf(null)
    val ubicacionDetail: State<Ubicacion?> = _ubicacionDetail

    init{
        //cargar los datos
        fetchPersonajes()
        personajesFiltered.value = personajesVM.value
    }

    private fun fetchPersonajes() {
        viewModelScope.launch {
            try {
                _personajes.value = repository.getPersonajes().results
                println("Personajes cargados: ${_personajes.value}")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    fun fetchPersonajeDetail(personajeId: String) {
        viewModelScope.launch {
            _personajeDetail.value = repository.getPersonajeDetail(personajeId)
        }
    }

    fun fetchUbicacionDetail(ubicacionId: String) {
        viewModelScope.launch {
            _ubicacionDetail.value = repository.getUbicacion(ubicacionId)
        }
    }
}