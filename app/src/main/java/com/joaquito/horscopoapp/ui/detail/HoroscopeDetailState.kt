package com.joaquito.horscopoapp.ui.detail

import com.joaquito.horscopoapp.domain.model.HoroscopeModel

//creamos una clase sellada de lo que pasa en cada estado para definirlo en la activity
sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()
    data class Success(val prediction:String, val sign:String, val horoscopeModel: HoroscopeModel):HoroscopeDetailState()
}