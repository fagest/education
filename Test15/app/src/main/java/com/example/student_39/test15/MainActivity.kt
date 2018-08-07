package com.example.student_39.test15

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

/**
 * тестовое задание 15
 * created 01.08.2018 by Sergey V.Makarov
 * email:fagest@yandex.ru
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        val items =//listOf<String>("Первый элемент","Второй элемент","Третий элемент")
                (1..100).map { i -> "Элемент #${i}" }
      //  val adapter = RecyclerAdaptrer(items)
        val adapter = RecyclerAdaptrer()
        adapter.setItems(items)

        recyclerView.adapter = adapter
        adapter.setOnRecyclerClicked(object : RecyclerAdaptrer.OnRecyclerClicked {
            override fun onClick(text: String) {
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_LONG).show()
            }
        })

    }
}
