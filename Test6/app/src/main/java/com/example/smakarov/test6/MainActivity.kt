package com.example.smakarov.test6

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

/**
 * тестовое задание 6
 * created 23.07.2018 by Sergey V.Makarov
 * email:fagest@yandex.ru
 *
 */
class MainActivity : AppCompatActivity() {
    private lateinit var email :EditText
    private lateinit var password:EditText
    private lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        email = findViewById<EditText>(R.id.email)
        password = findViewById<EditText>(R.id.password)
        button = findViewById<Button>(R.id.button)
        button.setBackgroundColor(Color.LTGRAY)
        button.setEnabled(false)
        var actionId = email.imeActionId
        email.setOnEditorActionListener { _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                Toast.makeText(this, email.text, Toast.LENGTH_LONG).show()
                true
            } else {
                false
            }
        }
/*
editText.addTextChangedListener(new TextWatcher(){
    @Override    public void afterTextChanged(Editable s) {   }
    @ Override    public void beforeTextChanged(CharSequence s, int start, int count, int after) {     }
    @Override    public void onTextChanged(CharSequence s, int start, int before, int count) {     } });

*/
        email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                button.setBackgroundColor(Color.MAGENTA)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
        actionId = password.imeActionId

        password.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                Toast.makeText(this, password.text, Toast.LENGTH_LONG).show()
                true
            } else {
                false
            }

        }

        password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                button.setEnabled(true)
                if(password.text.length>0&&email.text.length>0)
                   button.setBackgroundColor(Color.GREEN)
                else
                   button.setBackgroundColor(Color.LTGRAY)

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        button.setOnClickListener {
            if (button.isEnabled&&password.text.length>0&&email.text.length>0){
                Toast.makeText(this, "email: " + email.text + " password: " + password.text, Toast.LENGTH_LONG).show()
            button.setBackgroundColor(Color.LTGRAY)}
        }

    }
    }

