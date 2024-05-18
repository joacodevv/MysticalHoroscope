package com.joaquito.horscopoapp.data.network.response

import com.joaquito.horscopoapp.motherobject.HoroscopeMotherObject
import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class PredictionRespondeTest{

    @Test

    //dividir test en 3 partes
    fun `toDomain should return a correct PredictionModel`(){
        //given (proporcionar info necesaria)(testear la clase)
            val horoscopeResponse = HoroscopeMotherObject.anyResponse.copy(sign = "libra")
        //when (cuando ocurra algo)
            val predictionModel = horoscopeResponse.toDomain()
        //then (verificacion)
            predictionModel.sign shouldBe  horoscopeResponse.sign
            predictionModel.horoscope shouldBe  horoscopeResponse.horoscope

    }

}