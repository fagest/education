package com.example.student_39.test17

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ArgsFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_level_up,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.fragent_text_view)
        val button =view.findViewById<Button>(R.id.fragment_button)
        val buttonClear =view.findViewById<Button>(R.id.fragment_button_clear)
       // textView.setText("Изменили текст 0 раз")
        var counter =1
        button.setOnClickListener{
           // textView.setText("Изменили текст ${counter} раз")
           // counter++
            textView.text=arguments?.getString("ARGS_KEY")
        }
        buttonClear.setOnClickListener{
            textView.setText("Изменили текст 0 раз")
            textView.setText("")
          //  counter =1
        }
    }
    companion object {

        private val ARGS_KEY="ARGS_KEY"
        fun newInstance(textToSend:String):ArgsFragment{
            val fragment =ArgsFragment()
            val args =Bundle()
            args.putString(ARGS_KEY,textToSend)
            fragment.arguments =args
            return fragment

        }
    }
}

