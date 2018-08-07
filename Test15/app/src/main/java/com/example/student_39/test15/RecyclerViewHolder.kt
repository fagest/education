package com.example.student_39.test15

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Класс записывает текст во вью
 * created 01.08.2018 by Sergey V.Makarov
 * email:fagest@yandex.ru
 */
class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textView: TextView = itemView.findViewById(R.id.recycler_text)
    /**
     * присвоение всех полей обязательно
     */
    fun bind(textToShow: String) {
        textView.text = textToShow
      //  city.text
     //  if(forecast.temperature<0
    }

}