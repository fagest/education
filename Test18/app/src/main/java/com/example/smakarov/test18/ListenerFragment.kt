package com.example.smakarov.test18

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ListenerFragment : Fragment() {

    private lateinit var buttonRed: Button
    private lateinit var buttonGreen: Button
    private lateinit var buttonBlue: Button


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_listener, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonRed = view.findViewById<Button>(R.id.fragment_button_red)
        buttonGreen = view.findViewById<Button>(R.id.fragment_button_green)
        buttonBlue = view.findViewById<Button>(R.id.fragment_button_blue)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        buttonRed.setOnClickListener {
            // (activity as? OpenNewFragmentListener)?.open()
            fragmentManager?.beginTransaction()
                    ?.replace(R.id.bottom_fragment_container, LevelUpFragment.newInstance("RED"))
                    ?.addToBackStack(null)
                    ?.commit()
        }
        buttonGreen.setOnClickListener {
            fragmentManager?.beginTransaction()
                    ?.replace(R.id.bottom_fragment_container, LevelUpFragment.newInstance("GREEN"))
                    ?.addToBackStack(null)
                    ?.commit()
        }
        buttonBlue.setOnClickListener {
            fragmentManager?.beginTransaction()
                    ?.replace(R.id.bottom_fragment_container, LevelUpFragment.newInstance("BLUE"))
                    ?.addToBackStack(null)
                    ?.commit()
        }
    }

    interface OpenNewFragmentListener {
        fun open()
    }
}