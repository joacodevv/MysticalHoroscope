package com.joaquito.horscopoapp.ui.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.joaquito.horscopoapp.databinding.ItemHoroscopeBinding
import com.joaquito.horscopoapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo){
        val context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)
    }

}