package com.example.smakarov.test16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * тестовое задание 16
 * created 02.08.2018 by Sergey V.Makarov
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
        //   val items =//listOf<String>("Первый элемент","Второй элемент","Третий элемент")
        //         (1..100).map { i -> "Элемент #${i}" }
        //  val adapter = RecyclerAdaptrer(items)
        val items: MutableList<Forecast> = mutableListOf()
        items += Forecast("Минск",10,"Арбузы сладки")
        items += Forecast("Москва",0,"Купаться можно")
        items += Forecast("Челябинск",32,"Оденься потеплее")
        items += Forecast("Нарьян-Мар",-10,"Искупнись")
        items += Forecast("Свердловск",+10,"Броня наша крепка")
        items += Forecast("Киев",10,"Темна украинская ночь,\nно сало лучше перепрятать")
        items += Forecast("Варшава",10,"Dlatshego")
        items += Forecast("Коппенгаген",10,"Бррр...")
        items += Forecast("Хельсинки",10,"Горячие финские парни")
        items += Forecast("Норвегия",10,"Там где фьорды")
        items += Forecast("Осло",10,"Тут ослов мало")
        items += Forecast("Стокгольм",-10,"Где Карлсон")
        items += Forecast("Тирана",10,"И здесь арабы")
        items += Forecast("Брюссель",10,"Капусту не желаете")
        items += Forecast("Париж",10,"Мусью")
        items += Forecast("Берлин",10,"Нах остен")
        items += Forecast("Рим",10,"Аморе аморе")
        items += Forecast("Вена",10,"Ну Вена и шо")
        items += Forecast("Мадрид",50,"Бык не пробегал")
        items += Forecast("Афины",10,"Афина  Паллада")
        val adapter = RecyclerAdapter()
        adapter.setItems(items)

        recyclerView.adapter = adapter
        adapter.setOnRecyclerClicked(object : RecyclerAdapter.OnRecyclerClicked {
            override fun onClick(forecast: Forecast) {
                Toast.makeText(this@MainActivity, forecast.city, Toast.LENGTH_LONG).show()
            }
        })
    }

    data class Forecast(val city: String, val temperature: Int, val description: String)
}
