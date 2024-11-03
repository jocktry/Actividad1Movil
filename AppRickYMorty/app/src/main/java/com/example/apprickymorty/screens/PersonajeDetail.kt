package com.example.apprickymorty.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.apprickymorty.viewModel.ListPersonajeViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.apprickymorty.R

@Composable
fun PersonajeDetailScreen(personajeId: String,
                          viewModel: ListPersonajeViewModel,
                          onBackClick: () -> Unit,
                          navController: NavController
) {
    // Llama a la función para cargar detalles solo si el personajeId no es nulo

    viewModel.fetchPersonajeDetail(personajeId)
    val personajeDetail = viewModel.personajeDetail.value

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        IconButton(onClick = onBackClick) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Text(
            text = stringResource(id = R.string.Character_details),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        personajeDetail?.let { personaje ->
            // Imagen del personaje en un tamaño más grande
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberImagePainter(personaje.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp))
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Card con detalles del personaje
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
                        text = "Nombre: ${personaje.name}",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Estado: ${personaje.status}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Especie: ${personaje.species}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Divider(
                        modifier = Modifier
                            .height(1.dp),
                        color = androidx.compose.ui.graphics.Color.Gray
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    if (personaje.origin.url.length > 0) {
                        val locationId = personaje.origin.url.split("/").last()
                        Text(color=  MaterialTheme.colorScheme.tertiary, text = "Lugar origen: ${personaje.origin.name}", modifier = Modifier.clickable {
                            navController.navigate("ubicacion_screen/${locationId}")
                        })}
                    else{
                        Text(text = "Lugar origen: ${personaje.origin.name}")
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Divider(
                        modifier = Modifier
                            .height(1.dp),
                        color = androidx.compose.ui.graphics.Color.Gray
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    if (personaje.location.url.length > 0) {
                        val locationId = personaje.location.url.split("/").last()
                        Text(color=  MaterialTheme.colorScheme.tertiary, text = "Última ubicación: ${personaje.location.name}", modifier = Modifier.clickable {
                            navController.navigate("ubicacion_screen/${locationId}")
                    })}
                    else{
                        Text(text = "Última ubicación: ${personaje.location.name}")
                    }
                }
            }
        } ?: Text("Cargando detalles del personaje...")
    }
}


