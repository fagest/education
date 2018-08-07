package com.example.smakarov.test14

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

/**
 * тестовое задание 14
 * created 01.08.2018 by Sergey V.Makarov
 * email:fagest@yandex.ru
 *
 */
class ThirdActivity : AppCompatActivity() {
    private val TAG = "TESSTTT14_3"
    private val KEY_THIRD = "KEY14_3"
    private val KEY_FIRST = "KEY14_1"
    private val KEY_SECOND = "KEY14_2"
    private lateinit var buttonThird: Button
    private lateinit var textThird: TextView
    /**
     * коллекция значений полей экранов
     */
    private var lad: List<Entity.Data> = emptyList<Entity.Data>()
    /**
     * флаг разрешения нажатия кнопки
     */
    private var flag: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        Log.d(TAG, "onCreate")

        (this as AppCompatActivity).supportActionBar?.title = resources.getString(R.string.header_third)
        textThird = findViewById<EditText>(R.id.text_third)
        val textFirst = intent.extras.getString(KEY_FIRST)
        textThird.text = Editable.Factory.getInstance().newEditable(textFirst)

        buttonThird = findViewById<Button>(R.id.button_third)

        buttonThird.setOnClickListener {
            if (flag){
                lad += Entity.Data(KEY_SECOND, textFirst)
                lad += Entity.Data(KEY_THIRD, textThird.text.toString())
                openNewScreen(lad)

            }
        }

        textThird.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (textThird.length() > 0) {
                    buttonThird.setBackgroundColor(Color.YELLOW)
                    flag = true
                } else {
                    buttonThird.setBackgroundColor(Color.LTGRAY)
                    flag = false
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })


    }

    private fun openNewScreen(coll: List<Entity.Data>) {
        if (textThird.length() > 0) {
            val intent = Intent(this, SecondActivity::class.java)

            for (i in coll.indices) {
                intent.putExtra(coll[i].key, coll[i].data)
                Log.d(TAG,"key:${coll[i].key} data:${coll[i].data}")
            }
            //intent.putParcelableArrayListExtra("coll",coll)
            setResult(RESULT_OK, intent);
           // startActivityForResult(intent, 111);
            finish()

        }

    }
}