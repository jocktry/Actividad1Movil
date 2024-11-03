package com.example.apprickymorty


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apprickymorty.repository.PersonajeRepository
import com.example.apprickymorty.screens.ListPersonaje
import com.example.apprickymorty.screens.PersonajeDetailScreen
import com.example.apprickymorty.screens.UbicacionScreen
import com.example.apprickymorty.ui.theme.AppRickYMortyTheme
import com.example.apprickymorty.viewModel.ListPersonajeViewModel
import com.example.apprickymorty.viewModel.ListPersonajeViewModelFactory

//Clase Main
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppRickYMortyTheme {
                val navController = rememberNavController() // Controlador de navegación
                val personajeRepository = PersonajeRepository()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(navController, innerPadding, personajeRepository)

                }
            }
        }
    }
}@Composable
fun AppNavigation(navController: NavHostController, innerPadding: PaddingValues,
                  personajeRepository: PersonajeRepository) {

    // Crea el ViewModel
    val viewModelFactory = ListPersonajeViewModelFactory(personajeRepository)
    val personajesVM: ListPersonajeViewModel = viewModel(factory = viewModelFactory)

    // Define el NavHost con los destinos de navegación
    NavHost(
        navController = navController,
        startDestination = "list_personaje" // Pantalla de inicio
    ) {
        composable("list_personaje") {
            ListPersonaje(
                personajesVM = personajesVM,
                innerPadding = innerPadding,
                onPersonajeClick = { personaje ->
                    // Navegar a la pantalla de detalle cuando se selecciona un personaje
                    navController.navigate("personaje_detail/${personaje.id}")
                }
            )
        }

        composable("personaje_detail/{personajeId}") { backStackEntry ->
            val personajeId = backStackEntry.arguments!!.getString("personajeId")
            PersonajeDetailScreen(
                personajeId = personajeId!!,
                viewModel = personajesVM,
                onBackClick = { navController.popBackStack() },
                navController = navController)
        }

        composable("ubicacion_screen/{ubicacionId}") { backStackEntry ->
            val ubicacionId = backStackEntry.arguments!!.getString("ubicacionId")
                UbicacionScreen(
                    ubicacionId = ubicacionId!!,
                    viewModel = personajesVM,
                    onBackClick = { navController.popBackStack() }
                )

        }
    }
}

