package com.example.apprickymorty.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apprickymorty.repository.PersonajeRepositoryI

class ListPersonajeViewModelFactory(private val repository: PersonajeRepositoryI) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListPersonajeViewModel::class.java)) {
            return ListPersonajeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}