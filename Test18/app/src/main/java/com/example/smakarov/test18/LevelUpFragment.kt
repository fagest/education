package com.example.smakarov.test18

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class LevelUpFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_level_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {

            val color: String? = arguments?.getString("ARGS_KEY")
            if (color == "GREEN")
                view.setBackgroundColor(Color.GREEN)
            if (color == "RED")
                view.setBackgroundColor(Color.RED)
            if (color == "BLUE")
                view.setBackgroundColor(Color.BLUE)
        }

    }

    companion object {

        private val ARGS_KEY = "ARGS_KEY"
        fun newInstance(textToSend: String): LevelUpFragment {
            val fragment = LevelUpFragment()
            val args = Bundle()
            args.putString(ARGS_KEY, textToSend)
            fragment.arguments = args
            return fragment

        }
    }

}