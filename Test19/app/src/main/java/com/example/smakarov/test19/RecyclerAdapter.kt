package com.example.smakarov.test19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * адаптер
 * created 02.08.2018 by Sergey V.Makarov
 * email:fagest@yandex.ru
 *
 */
class RecyclerAdapter : RecyclerView.Adapter<RecyclerViewHolder>() {
    private var items :MutableList<MainActivity.Forecast> = mutableListOf()
    private var onRecyclerClicked: OnRecyclerClicked? = null


    fun setItems(newItems:List<MainActivity.Forecast>){

        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
    /**
     * позиция отображаемого вью
     */
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val forecast = items[position]
        holder.bind(forecast)
        holder.itemView.setOnClickListener {
            //    Toast.makeText(holder.itemView.context,textToShow,Toast.LENGTH_LONG).show()
            onRecyclerClicked?.onClick(forecast)
        }
    }

    /**
     * размер нашего листа
     */
    override fun getItemCount(): Int = items.size

    /**
     * viewType для изменения возвращаемого холдера
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder, parent, false)
        return RecyclerViewHolder(view)
    }

    interface OnRecyclerClicked {
        fun onClick(text: MainActivity.Forecast)
    }

    fun setOnRecyclerClicked(onRecyclerClicked: OnRecyclerClicked?) {
        this.onRecyclerClicked = onRecyclerClicked
    }
}