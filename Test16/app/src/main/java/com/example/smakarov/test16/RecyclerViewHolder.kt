package com.example.smakarov.test16

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Класс записывает текст во вью
 * created 02.08.2018 by Sergey V.Makarov
 * email:fagest@yandex.ru
 */
class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    //  private val textView: TextView = itemView.findViewById(R.id.recycler_text)
    private val textCity: TextView = itemView.findViewById(R.id.city)
    private val textTemperature: TextView = itemView.findViewById(R.id.temperature)
    private val textC: TextView = itemView.findViewById(R.id.textС)
    private val textDescription: TextView = itemView.findViewById(R.id.description)
    private val defaultColor:Int = Color.parseColor("#bdbdbd")
    /**
     * присвоение всех полей обязательно
     */
    fun bind(forecast: MainActivity.Forecast) {
        textCity.text = forecast.city
        textTemperature.text = "${forecast.temperature.toString()}"
        if(forecast.temperature>0){
            textTemperature.text = "+${forecast.temperature.toString()}"
        }
        textDescription.text = forecast.description
        textTemperature.setTextColor(defaultColor)
        textC.setTextColor(defaultColor)
        if (forecast.temperature < 0)
            textTemperature.setTextColor(Color.parseColor("#0000ff"))

        if (forecast.temperature > 30)
            textTemperature.setTextColor(Color.parseColor("#ff0000"))
    }
}

