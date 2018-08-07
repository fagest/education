package com.example.student_39.test17

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_level_up.*

class LeveUpFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_level_up,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.fragent_text_view)
        val button =view.findViewById<Button>(R.id.fragment_button)
        val buttonClear =view.findViewById<Button>(R.id.fragment_button_clear)
        textView.setText("Изменили текст 0 раз")
        var counter =1
        button.setOnClickListener{
            textView.setText("Изменили текст ${counter} раз")
            counter++
        }
         buttonClear.setOnClickListener{
             textView.setText("Изменили текст 0 раз")
             counter =1
         }
    }


}