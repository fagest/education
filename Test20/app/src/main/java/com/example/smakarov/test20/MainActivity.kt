package com.example.smakarov.test20

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/**
 * Тестовое задание 20
 *eated 08.08.2018 by Segey V.Makarov
 * email:fagest@yandex.ru
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.top_fragment_container, ListenerFragment())
                    .commit()
        }
    }
}
