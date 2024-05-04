package com.joaquito.horscopoapp.data.network

import com.joaquito.horscopoapp.data.network.response.PredictionResponde
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {
    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign:String):PredictionResponde


}