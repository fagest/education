package com.example.smakarov.test19

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListenerFragment : Fragment() {




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_listener, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        //   val items =//listOf<String>("Первый элемент","Второй элемент","Третий элемент")
        //         (1..100).map { i -> "Элемент #${i}" }
        //  val adapter = RecyclerAdaptrer(items)
        val items: MutableList<MainActivity.Forecast> = mutableListOf()
        items += MainActivity.Forecast("Питер", 10, "Арбузы сладки")
        items += MainActivity.Forecast("Москва", 0, "Купаться можно")
        items += MainActivity.Forecast("Челябинск", 32, "Оденься потеплее")
        items += MainActivity.Forecast("Нарьян-Мар", -10, "Искупнись")
        items += MainActivity.Forecast("Свердловск", +10, "Броня наша крепка")
        items += MainActivity.Forecast("Киев", 10, "Темна украинская ночь,\nно сало лучше перепрятать")
        items += MainActivity.Forecast("Варшава", 10, "Dlatshego")
        items += MainActivity.Forecast("Коппенгаген", 10, "Бррр...")
        items += MainActivity.Forecast("Хельсинки", 10, "Горячие финские парни")
        items += MainActivity.Forecast("Норвегия", 10, "Там где фьорды")
        items += MainActivity.Forecast("Осло", 10, "Тут ослов мало")
        items += MainActivity.Forecast("Стокгольм", -10, "Где Карлсон")
        items += MainActivity.Forecast("Тирана", 10, "И здесь арабы")
        items += MainActivity.Forecast("Брюссель", 10, "Капусту не желаете")
        items += MainActivity.Forecast("Париж", 10, "Мусью")
        items += MainActivity.Forecast("Берлин", 10, "Нах остен")
        items += MainActivity.Forecast("Рим", 10, "Аморе аморе")
        items += MainActivity.Forecast("Вена", 10, "Ну Вена и шо")
        items += MainActivity.Forecast("Мадрид", 50, "Бык не пробегал")
        items += MainActivity.Forecast("Афины", 10, "Афина  Паллада")
        val adapter = RecyclerAdapter()
        adapter.setItems(items)

        recyclerView.adapter = adapter
        adapter.setOnRecyclerClicked(object : RecyclerAdapter.OnRecyclerClicked {
            override fun onClick(forecast: MainActivity.Forecast) {
               // Toast.makeText(this@MainActivity, forecast.city, Toast.LENGTH_LONG).show()

                //    Toast.makeText(context, forecast.city, Toast.LENGTH_SHORT).show()
                    fragmentManager?.beginTransaction()
                            ?.replace(R.id.bottom_fragment_container, ViewFragment.newInstance(forecast.city))
                            ?.addToBackStack(null)
                            ?.commit()

            }
        })

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    interface OpenNewFragmentListener {
        fun open()
    }
}