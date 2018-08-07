package com.example.student_41.test12

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class ActivityThird : AppCompatActivity() {

    private val TAG = "TESSTTT12_3"
    private val KEY = "TESSTTT12_1"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        (this as AppCompatActivity).supportActionBar?.title = resources.getString(R.string.header_third)
        val textThird  = findViewById<TextView>(R.id.text_third)

        textThird.text = intent.extras.getString(KEY)


    }



}