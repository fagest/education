package com.example.student_41.test13

import android.content.Intent
import android.graphics.Color

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val TAG = "TESSTTT12_1"
    private val KEY = "TESSTTT12_1"
    private lateinit var textFirst: EditText
    private lateinit var buttonFirst: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate");

        setContentView(R.layout.activity_main)


        (this as AppCompatActivity).supportActionBar?.title = resources.getString(R.string.header_first)


        textFirst = findViewById<EditText>(R.id.text_first)
        buttonFirst = findViewById<Button>(R.id.button_first)
        buttonFirst.setBackgroundColor(Color.LTGRAY)
        buttonFirst.setOnClickListener {
            if(textFirst.length()>0)
            openNewScreen(textFirst.text.toString())
         }
        textFirst.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(textFirst.length()>0)
                buttonFirst.setBackgroundColor(Color.MAGENTA)
                else
                buttonFirst.setBackgroundColor(Color.LTGRAY)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

    }

    private fun openNewScreen(s: String) {
        val intent = Intent(this, ActivitySecond::class.java)
                .apply { putExtra(KEY, s) }

        startActivity(intent)
    }


}
