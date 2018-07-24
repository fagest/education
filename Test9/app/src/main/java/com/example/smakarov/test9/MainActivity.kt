package com.example.smakarov.test9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text=findViewById<TextView>(R.id.text100)
        text.setOnClickListener {
            Toast.makeText(this,"Ну я же просил нежно!!",Toast.LENGTH_LONG).show()
        }
    }
}
