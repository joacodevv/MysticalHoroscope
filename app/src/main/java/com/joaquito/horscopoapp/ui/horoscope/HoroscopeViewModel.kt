package com.joaquito.horscopoapp.ui.horoscope

import android.view.View
import androidx.lifecycle.ViewModel
import com.joaquito.horscopoapp.data.providers.HoroscopeProvider
import com.joaquito.horscopoapp.domain.model.HoroscopeInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
//el viewmodel necesita del provider para que le de informacion
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider):ViewModel() {

    //hacemos un stateflow mutable creando una lista vacia para meterle la data de HoroscopeInfo
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope:StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        //inicamos el viewmodel proveendonos una lista de los signos del provider
        horoscopeProvider.getHoroscopes()
        //llenamos la lista vacia con lo que nos dio el provider
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }
}