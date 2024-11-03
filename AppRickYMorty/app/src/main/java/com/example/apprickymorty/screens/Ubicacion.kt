package com.example.apprickymorty.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apprickymorty.viewModel.ListPersonajeViewModel


@Composable
fun UbicacionScreen(ubicacionId: String, viewModel: ListPersonajeViewModel, onBackClick: () -> Unit) {
    // Llamar a la función para cargar los datos de la ubicación
    viewModel.fetchUbicacionDetail(ubicacionId)

    val ubicacion = viewModel.ubicacionDetail.value

    Column(modifier = Modifier.padding(16.dp)) {
        IconButton(onClick = onBackClick) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
        ubicacion?.let { ubicacion ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Nombre: ${ubicacion.name}",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = "Tipo: ${ubicacion.type}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Dimensión: ${ubicacion.dimension}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }?: Text("Cargando detalles de la ubicación...")
    }
}