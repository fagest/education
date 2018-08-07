package com.example.student_39.test17

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/**
 * тестовое задание 17
 * created 03.08.2018 by Sergey V.Makarov
 * email:fagest@yandex.ru
 *
 */
class MainActivity : AppCompatActivity(),ListenerFragment.OpenNewFragmentListener {
    override fun open() {
//        supportFragmentManager
//                .beginTransaction()
//             //   .replace(R.id.bottom_fragment_container, ArgsFragment.newInstance("bottom"))
//                .replace(R.id.bottom_fragment_container, ListenerFragment())
//                .addToBackStack(null)
//                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            /*
            val fragmentTransition = getSupportFragmentManager().beginTransaction()
          //  fragmentTransition.replace(R.id.fragment_container,LeveUpFragment())
            fragmentTransition.replace(R.id.fragment_container,ArgsFragment.newInstance("blblflfl"))
            fragmentTransition.commit()
            */
            /*
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.top_fragment_container, ArgsFragment.newInstance("top"))
                    .commit()
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.bottom_fragment_container, ArgsFragment.newInstance("bottom"))
                    .commit()
                    */

            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.top_fragment_container,ListenerFragment())
                    .commit()

        }
    }
}
