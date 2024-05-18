package com.joaquito.horscopoapp.ui.horoscope

import com.joaquito.horscopoapp.data.providers.HoroscopeProvider
import com.joaquito.horscopoapp.motherobject.HoroscopeMotherObject
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class HoroscopeViewModelTest{

    //mockeamos el provider para q no afecte
    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    //cuando hay logica compartida(viewmodels) se puede inicializar antes
    private lateinit var viewModel: HoroscopeViewModel

    @Before
    //realizar algo antes de un test
    fun setUp(){
        //necesario para que funcione mockk
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewmodel is created then horoscopes are loaded`(){

        //el viewmodel necesita del provider
        //se necesita mockear el provider (hacer un provider falso para q no se proporcione realmente la info)
        //al querer testear el viewmodel hay q mockear el provider para q no se haga la llamada

        //fakear la respuesta (si es con coorutinas en vez de every es coEvery)
        every { horoscopeProvider.getHoroscopes() } returns HoroscopeMotherObject.horoscopeInfoList

        viewModel = HoroscopeViewModel(horoscopeProvider)

        //when
        val horoscopes = viewModel.horoscope.value

        //then (comprobamos q la lista no este vacia)
        assertTrue(horoscopes.isNotEmpty())






    }
}