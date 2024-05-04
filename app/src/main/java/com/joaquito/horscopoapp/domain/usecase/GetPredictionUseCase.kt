package com.joaquito.horscopoapp.domain.usecase

import com.joaquito.horscopoapp.domain.Repository
import com.joaquito.horscopoapp.domain.model.PredictionModel
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(sign:String):PredictionModel?{
      return repository.getPrediction(sign)
    }
}