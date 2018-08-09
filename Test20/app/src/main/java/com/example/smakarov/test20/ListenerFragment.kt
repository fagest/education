package com.example.smakarov.test20

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

class ListenerFragment : Fragment() {
    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var nameAndGender: TextView
    private lateinit var heightAndMass: TextView
    private lateinit var starWarsApi: StarWarsApi
    private var count: Int = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_listener, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById<TextView>(R.id.text_view)
        editText = view.findViewById<EditText>(R.id.edit_text)
        button = view.findViewById<Button>(R.id.button)
        nameAndGender = view.findViewById<TextView>(R.id.name_and_gender)
        heightAndMass = view.findViewById<TextView>(R.id.height_and_mass)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .build()



        starWarsApi = retrofit.create(StarWarsApi::class.java)
        starWarsApi.getFirstPerson(1).enqueue(object : Callback<StarWarsPerson> {
            override fun onFailure(call: Call<StarWarsPerson>, t: Throwable?) {
                Log.e("STAR_WARS", "Error happened:$t")
            }

            override fun onResponse(call: Call<StarWarsPerson>, response: Response<StarWarsPerson>) {
                val starWarsPerson = response.body()
                if (starWarsPerson != null)
                    bind(starWarsPerson)
            }
        })
    }

    private fun createOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
                .apply { level = HttpLoggingInterceptor.Level.BODY }
        val builder = OkHttpClient.Builder()
                .connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(httpLoggingInterceptor)
        }
        return builder.build()
    }

    fun bind(starWarsPerson: StarWarsPerson) {
        nameAndGender.text = "${starWarsPerson.name}(${starWarsPerson.gender})"
        heightAndMass.text = "Height: ${starWarsPerson.height} cm.Mass: ${starWarsPerson.mass} kg"
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val sharedPrefs = activity?.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val savedValue = sharedPrefs?.getString(ADVERTISING_TEXT_KEY, null)
        savedValue?.let { savedText -> textView.text = savedText }
        button.setOnClickListener {
            val ourText = editText.text.toString()
            textView.text = ourText
            sharedPrefs?.let { saveToSharedPref(it, ourText) }

            starWarsApi.getFirstPerson(count).enqueue(object : Callback<StarWarsPerson> {
                override fun onFailure(call: Call<StarWarsPerson>, t: Throwable?) {
                    Log.e("STAR_WARS", "Error happened:$t")
                }

                override fun onResponse(call: Call<StarWarsPerson>, response: Response<StarWarsPerson>) {
                    val starWarsPerson = response.body()
                    if (starWarsPerson != null)
                        bind(starWarsPerson)
                }
            })
            count++
            if (count > 10) count = 1
        }

    }

    fun saveToSharedPref(sharedPrefs: SharedPreferences, text: String) {
        sharedPrefs.edit().putString(ADVERTISING_TEXT_KEY, text).apply()
    }

    interface OpenNewFragmentListener {
        fun open()
    }

    companion object {
        private const val SHARED_PREF_NAME = "our_app_sp"
        private const val ADVERTISING_TEXT_KEY = "ADVERTISING_TEXT_KEY"

    }


}

data class StarWarsPerson(
        val name: String,
        val mass: String,
        val height: String,
        val gender: String
)

interface StarWarsApi {
    @GET("/api/people/{person_id}")
    fun getFirstPerson(@Path("person_id") personId: Int): Call<StarWarsPerson>
}