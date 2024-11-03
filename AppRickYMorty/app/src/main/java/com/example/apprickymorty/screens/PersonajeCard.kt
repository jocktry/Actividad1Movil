package com.example.apprickymorty.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.apprickymorty.data.Personaje

@Composable
fun PersonajeCard(personaje: Personaje){
    Column(modifier=
        Modifier
            .fillMaxSize()){
        Text(personaje.name)
    }
}

