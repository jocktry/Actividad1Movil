package com.example.apprickymorty.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apprickymorty.viewModel.ListPersonajeViewModel

@Composable
fun ListPersonaje(personajesVM: ListPersonajeViewModel, innerPadding:PaddingValues){
    //Layout Columna
    //Column(modifier = Modifier.padding(innerPadding)){
      LazyColumn (modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize()
      ){
          personajesVM.personajesVM.value.forEach{personaje ->
            item {
                PersonajeCard(personaje)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

}
