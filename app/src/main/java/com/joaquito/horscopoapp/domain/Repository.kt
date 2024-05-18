package com.joaquito.horscopoapp.domain

import com.joaquito.horscopoapp.domain.model.PredictionModel


interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}