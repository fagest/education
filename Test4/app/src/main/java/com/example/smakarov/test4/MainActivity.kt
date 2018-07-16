package com.example.smakarov.test4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation



/**
 * тестовое задание 4
 * created 16.07.2018 by Sergey V.Makarov
 * email:fagest@yandex.ru
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textV =findViewById<TextView>(R.id.text_v)
        textV.setText(R.string.test_name)
       // val ranim = AnimationUtils.loadAnimation(this, R.anim.myanim) as RotateAnimation
       // ranim.fillAfter = true //For the textview to remain at the same place after the rotation
       // textV.setAnimation(ranim)

    }
}
