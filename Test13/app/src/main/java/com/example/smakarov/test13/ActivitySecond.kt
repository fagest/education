package com.example.student_41.test13

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smakarov.test13.R

class ActivitySecond : AppCompatActivity() {

    private val TAG = "TESSTTT12_2"
    private val KEY = "TESSTTT12_1"
    private lateinit var buttonSecond: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        (this as AppCompatActivity).supportActionBar?.title = resources.getString(R.string.header_second)
        buttonSecond = findViewById<Button>(R.id.button_second)
        buttonSecond.setOnClickListener {
            openNewScreen(intent.extras.getString(KEY))
        }


    }

    private fun openNewScreen(s: String) {
        val intent = Intent(this, ActivityThird::class.java)
                .apply { putExtra(KEY, s) }

        startActivity(intent)
    }

}