package com.example.apprickymorty


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apprickymorty.screens.ListPersonaje
import com.example.apprickymorty.ui.theme.AppRickYMortyTheme
import com.example.apprickymorty.viewModel.ListPersonajeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppRickYMortyTheme {
                Scaffold(/*
                    topBar = {
                        TopAppBar(title = { Text("Personajes de Rick y Morty") })
                    },*/modifier = Modifier.fillMaxSize()) { innerPadding ->
                 //Creación View Model
                    val personajesVM = viewModel<ListPersonajeViewModel>()
                    //Lista de Personajes
                    ListPersonaje(personajesVM, innerPadding);
                }
            }
        }
    }
}

