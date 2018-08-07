package com.example.student_39.test17

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class ListenerFragment : Fragment() {

    private lateinit var button: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_listener, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.listener_button)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button.setOnClickListener {
            // (activity as? OpenNewFragmentListener)?.open()


            fragmentManager?.beginTransaction()
                        ?.replace(R.id.top_fragment_container, ListenerFragment())
                        ?.addToBackStack(null)
                        ?.commit()
            }

        }

    interface OpenNewFragmentListener {
        fun open()
    }
}