package com.joaquito.horscopoapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.joaquito.horscopoapp.databinding.ItemHoroscopeBinding
import com.joaquito.horscopoapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit){
        //seteamos cada dato a su xml
        val context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)

        //
        binding.parent.setOnClickListener {
            //iniciamos la animacion y navegamos a la pantalla correspondiente gracias a la lambda
            startRotationAnimation(binding.ivHoroscope, newLambda = {onItemSelected(horoscopeInfo)})
            onItemSelected(horoscopeInfo)

        }
    }

    //hacemos al animacion de rotar
    private fun startRotationAnimation(view: View, newLambda:()-> Unit){
        view.animate().apply {
            duration = 400
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{ newLambda }
            start()
        }
    }

}