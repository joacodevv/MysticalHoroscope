package com.joaquito.horscopoapp.data.providers

import com.joaquito.horscopoapp.domain.model.HoroscopeInfo
import com.joaquito.horscopoapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

//creamos una lista de HoroscopeInfo con cada objeto
class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}