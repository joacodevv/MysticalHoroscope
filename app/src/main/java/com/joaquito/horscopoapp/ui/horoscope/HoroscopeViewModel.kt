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
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider):ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope:StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        horoscopeProvider.getHoroscopes()
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }
}