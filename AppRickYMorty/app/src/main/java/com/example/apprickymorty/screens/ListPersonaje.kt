package com.example.apprickymorty.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.apprickymorty.R
import com.example.apprickymorty.data.Personaje
import com.example.apprickymorty.viewModel.ListPersonajeViewModel

@Composable
fun ListPersonaje(
    personajesVM: ListPersonajeViewModel,
    innerPadding: PaddingValues,
    onPersonajeClick: (Personaje) -> Unit // Callback de navegación
) {
    //variable usada para el filtrado de personaje
    var searchText by remember { mutableStateOf("") }

    // Filtrar la lista de personajes en función del texto de búsqueda
    val filteredPersonajes = personajesVM.personajesVM.value.filter {
        it.name.contains(searchText, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        // Título de la pantalla
        Text(
            text = stringResource(id = R.string.list_screen_title),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        // Campo de búsqueda
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text(stringResource(id = R.string.search_hint)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Lista de personajes
        LazyColumn {
            filteredPersonajes.forEach { personaje ->
                item {
                    PersonajeCard(personaje = personaje, onClick = { onPersonajeClick(personaje) })
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}
