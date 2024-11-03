package com.example.apprickymorty

import com.example.apprickymorty.viewModel.ListPersonajeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ViewModelTest {

    private lateinit var repository: FakeApiData
    private lateinit var viewModel: ListPersonajeViewModel
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher) // Establece el despachador principal
        repository = FakeApiData() // Inicializa el repositorio simulado
        viewModel = ListPersonajeViewModel(repository) // Inicializa el ViewModel
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Restablece el despachador principal después de la prueba
        testDispatcher.cleanupTestCoroutines() // Limpia el despachador de pruebas
    }

    @Test
    fun `actualiza lista de personajes cuando se crea el viewModel`() = testDispatcher.runBlockingTest {
        assert(viewModel.personajesVM.value.isNotEmpty())
    }
}
