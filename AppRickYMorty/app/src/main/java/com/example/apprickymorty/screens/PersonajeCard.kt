package com.example.apprickymorty.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.apprickymorty.data.Personaje

@Composable
fun PersonajeCard(personaje: Personaje, onClick: () -> Unit){
    Row(modifier = Modifier
        .padding(8.dp)
        .clickable { onClick() } // Navegar cuando se selecciona el personaje
    ) {
        Image(
            painter = rememberImagePainter(personaje.image),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(personaje.name, style = MaterialTheme.typography.headlineSmall)
            Text("Estado: ${personaje.status}", style = MaterialTheme.typography.bodyMedium)
            Text("Especie: ${personaje.species}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

