package com.example.apprickymorty.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apprickymorty.data.Personaje
import com.example.apprickymorty.repository.PersonajeRepository
import kotlinx.coroutines.launch

class ListPersonajeViewModel: ViewModel() {
    private val repository = PersonajeRepository()
    //Variable en memoria que almacena la lista de personajes
    private val _personajes:MutableState<List<Personaje>> = mutableStateOf(emptyList())
    //Variable publica observable
    var personajesVM: State<List<Personaje>> = _personajes

    init{
        //cargar los datos
        fetchPersonajes()
    }

    private fun fetchPersonajes() {
        viewModelScope.launch {
            _personajes.value = repository.getPersonajes().results
        }
    }

}