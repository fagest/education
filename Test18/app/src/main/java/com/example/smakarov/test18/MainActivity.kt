package com.example.smakarov.test18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * тестовое задание 18
 * created 07.08.2018 by Sergey V.Makarov
 * email:fagest@yandex.ru
 *
 */
class MainActivity : AppCompatActivity(),ListenerFragment.OpenNewFragmentListener {
    override fun open() {
//        supportFragmentManager
//                .beginTransaction()
//               //  .replace(R.id.bottom_fragment_container, ArgsFragment.newInstance("bottom"))
//             .replace(R.id.bottom_fragment_container, LevelUpFragment())
//                .addToBackStack(null)
//                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.top_fragment_container,ListenerFragment())
                    .commit()
        }
    }
}
