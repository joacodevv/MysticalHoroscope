package com.joaquito.horscopoapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaquito.horscopoapp.domain.model.HoroscopeModel
import com.joaquito.horscopoapp.domain.model.PredictionModel
import com.joaquito.horscopoapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
//conectamos con daggerhilt al caso de uso
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase):ViewModel() {

    //creamos el stateflow mutable
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state:StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope:HoroscopeModel


    fun getHoroscope(sign: HoroscopeModel){
        //en el hilo secundario rescatamos datos de backend y los comprobamos para definir el estado en la activity
        horoscope = sign
        viewModelScope.launch {
            _state.value = HoroscopeDetailState.Loading
           val result:PredictionModel? = withContext(Dispatchers.IO){getPredictionUseCase(sign.name)}
            if (result != null){
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
            }else{
                _state.value = HoroscopeDetailState.Error("Ha ocurrido un error, intentelo de nuevo más tarde")
            }
        }

    }
}