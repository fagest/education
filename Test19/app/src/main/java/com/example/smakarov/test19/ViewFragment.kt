package com.example.smakarov.test19

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.net.URL
import android.os.StrictMode
import android.util.Log


class ViewFragment : Fragment() {
    private lateinit var headCity: TextView
    private lateinit var imageCity: ImageView
    val TAG: String = "ViewFragment"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (android.os.Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }
        headCity = view.findViewById(R.id.head_city)
        imageCity = view.findViewById(R.id.image_city)
        val arg: String = arguments?.get("ARGS_KEY") as String
        imageCity.setImageResource(R.drawable.default_)
        var url: URL
        var uri: String

        headCity.text = arg
        if (arg.equals("Москва")) {
            // imageCity.setImageResource(R.drawable.moscow)
            //   setIcon("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Coat_of_arms_of_Moscow_Oblast_%28large%29.svg/220px-Coat_of_arms_of_Moscow_Oblast_%28large%29.svg.png")
            uri = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Coat_of_arms_of_Moscow_Oblast_%28large%29.svg/220px-Coat_of_arms_of_Moscow_Oblast_%28large%29.svg.png"
            url = URL(uri)
            try {
                val mIcon_val = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                imageCity.setImageBitmap(mIcon_val)
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
            }
        }
        if (arg.equals("Челябинск")) {
            uri = "https://upload.wikimedia.org/wikipedia/commons/0/04/Coat_of_Arms_of_Yuzhnouralsk_%28Chelyabinsk_oblast%29.png"
            //   setIcon("https://upload.wikimedia.org/wikipedia/commons/0/04/Coat_of_Arms_of_Yuzhnouralsk_%28Chelyabinsk_oblast%29.png")
            url = URL(uri)
            try {
                val mIcon_val = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                imageCity.setImageBitmap(mIcon_val)
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
            }
        }
        if(arg.equals("Питер")) {

            uri = "http://abali.ru/wp-content/uploads/2010/12/gerb_sankt-peterburga.png"
            url = URL(uri)
            try {
                val mIcon_val = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                imageCity.setImageBitmap(mIcon_val)
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
            }
        }
    }


    fun seIcon(uri: String): Unit {

        val url: URL = URL(uri)
        try {
            val mIcon_val = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imageCity.setImageBitmap(mIcon_val)
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }
    }

    companion object {

        private val ARGS_KEY = "ARGS_KEY"
        fun newInstance(textToSend: String): ViewFragment {
            val fragment = ViewFragment()
            val args = Bundle()
            args.putString(ARGS_KEY, textToSend)
            fragment.arguments = args
            return fragment

        }
    }
}