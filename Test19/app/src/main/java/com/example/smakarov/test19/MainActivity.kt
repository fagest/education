package com.example.smakarov.test19

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * тестовое задание 19
 * created 07.08.2018 by Sergey V.Makarov
 * email:fagest@yandex.ru
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val orientation: Int = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT)
            setContentView(R.layout.activity_main)
        else
            setContentView(R.layout.activity_main_)


        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.top_fragment_container, ListenerFragment())
                    .commit()
        }
    }


    data class Forecast(val city: String, val temperature: Int, val description: String)


}
