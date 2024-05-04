package com.joaquito.horscopoapp.data

import android.util.Log
import com.joaquito.horscopoapp.data.network.HoroscopeApiService
import com.joaquito.horscopoapp.data.network.response.PredictionResponde
import com.joaquito.horscopoapp.domain.Repository
import com.joaquito.horscopoapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) :Repository {
    override suspend fun getPrediction(sign: String):PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("joaco","pinchó ${it.message} ") }
        return null
    }

}