package com.joaquito.horscopoapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joaquito.horscopoapp.R
import com.joaquito.horscopoapp.domain.model.HoroscopeInfo

//iniciamos el adapter con una lista vacia y añadimos una funcion lambda para ver que item fue selecionado
class HoroscopeAdapter(private var horoscopeList:List<HoroscopeInfo> = emptyList(),
    private val onItemSelected:(HoroscopeInfo) -> Unit ):
    RecyclerView.Adapter<HoroscopeViewHolder>(){

    fun updateList(list: List<HoroscopeInfo>){
        //por las dudas por si se cambia algo en el HoroscopeInfo
        horoscopeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        return HoroscopeViewHolder(view)
    }

    override fun getItemCount() = horoscopeList.size



    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position], onItemSelected)
    }
}