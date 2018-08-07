package com.example.student_39.test15

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast

/**
 * адаптер
 * created 01.08.2018 by Sergey V.Makarov
 * email:fagest@yandex.ru
 *
 */
//class RecyclerAdaptrer(private val items: List<String>) : RecyclerView.Adapter<RecyclerViewHolder>() {
    class RecyclerAdaptrer : RecyclerView.Adapter<RecyclerViewHolder>() {
    private var items :MutableList<String> = mutableListOf()
    private var onRecyclerClicked: OnRecyclerClicked? = null


    fun setItems(newItems:List<String>){

        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
    /**
     * позиция отображаемого вью
     */
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val textToShow = items[position]
        holder.bind(textToShow)
        holder.itemView.setOnClickListener {
            //    Toast.makeText(holder.itemView.context,textToShow,Toast.LENGTH_LONG).show()
            onRecyclerClicked?.onClick(textToShow)
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
        fun onClick(text: String)
    }

    fun setOnRecyclerClicked(onRecyclerClicked: OnRecyclerClicked?) {
        this.onRecyclerClicked = onRecyclerClicked
    }
}