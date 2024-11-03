package com.example.apprickymorty.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apprickymorty.data.Personaje
import com.example.apprickymorty.data.Ubicacion
import com.example.apprickymorty.repository.PersonajeRepository
import kotlinx.coroutines.launch

class ListPersonajeViewModel: ViewModel() {
    private val repository = PersonajeRepository()

    //Variable en memoria que almacena la lista de personajes
    private val _personajes:MutableState<List<Personaje>> = mutableStateOf(emptyList())
    //Variable publica observable
    var personajesVM: State<List<Personaje>> = _personajes

    //Variable para el detalle de un personaje
    private val _personajeDetail: MutableState<Personaje?> = mutableStateOf(null)
    val personajeDetail: State<Personaje?> = _personajeDetail

    //Variables para la ubicacion de un personaje
    private val _ubicacionDetail: MutableState<Ubicacion?> = mutableStateOf(null)
    val ubicacionDetail: State<Ubicacion?> = _ubicacionDetail

    init{
        //cargar los datos
        fetchPersonajes()
    }

    private fun fetchPersonajes() {
        viewModelScope.launch {
            _personajes.value = repository.getPersonajes().results
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