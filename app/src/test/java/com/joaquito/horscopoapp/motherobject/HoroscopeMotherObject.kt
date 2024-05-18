package com.joaquito.horscopoapp.motherobject

import com.joaquito.horscopoapp.data.network.response.PredictionResponde
import com.joaquito.horscopoapp.domain.model.HoroscopeInfo

//centralizar testeo
//esta es una respuesta generica q se va modificando segun lo necesario en cada test en particular

object HoroscopeMotherObject {
    val anyResponse = PredictionResponde("date", "prediction", "taurus")


    //proporcionamos la lista para la falsa respuesta
    val horoscopeInfoList = listOf(
        HoroscopeInfo.Aries,
        HoroscopeInfo.Taurus,
        HoroscopeInfo.Gemini,
        HoroscopeInfo.Cancer,
        HoroscopeInfo.Leo,
        HoroscopeInfo.Virgo,
        HoroscopeInfo.Libra,
        HoroscopeInfo.Scorpio,
        HoroscopeInfo.Sagittarius,
        HoroscopeInfo.Capricorn,
        HoroscopeInfo.Aquarius,
        HoroscopeInfo.Pisces
    )
}