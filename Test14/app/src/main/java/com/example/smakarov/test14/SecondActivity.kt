package com.example.smakarov.test14

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class SecondActivity : AppCompatActivity() {

    private val TAG = "TESSTTT14_2"
    private val KEY_FIRST = "KEY14_1"
    private val KEY_THIRD = "KEY14_3"
    private val KEY_SECOND = "KEY14_2"
    private lateinit var buttonSecond: Button
    private var gson = Gson()
    private var response: String = ""
    lateinit var  textSecondActivity2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d(TAG, "onCreate")


        (this as AppCompatActivity).supportActionBar?.title = resources.getString(R.string.header_second)
        buttonSecond = findViewById<Button>(R.id.button_second)
        var lad: List<Entity.Data> = emptyList<Entity.Data>()//ArrayList<Entity.Data>()

        buttonSecond.setOnClickListener {

            //  openNewScreen(intent.extras.getString(KEY_FIRST))
            openNewScreen(lad)
            //чтобы закрыть активити и вернуться на предыдущий экран
            /*
            val Intent ........
            setResult(Activity.RESULT_OK,intent)
            finish()
             */


        }
     //   var textSecondActivity2: TextView
        var textSecondActivity1: TextView

        textSecondActivity2 = findViewById<TextView>(R.id.text_second_activity_2)
        textSecondActivity1 = findViewById<TextView>(R.id.text_second_activity_1)

        //  if (lad.isEmpty()) {
        if (intent.extras.getString(KEY_SECOND) == null)
            textSecondActivity1.text = intent.extras.getString(KEY_FIRST)
        else {
            textSecondActivity1.text = intent.extras.getString(KEY_SECOND)
            textSecondActivity2.text = intent.extras.getString(KEY_THIRD)
        }
        Log.d(TAG, "key = ${KEY_FIRST} data = ${intent.extras.getString(KEY_FIRST)}" +
                " key = ${KEY_THIRD} data = ${intent.extras.getString(KEY_THIRD)}"
        +" key = ${KEY_SECOND} data = ${intent.extras.getString(KEY_SECOND)}"
        )
        lad += Entity.Data(KEY_FIRST, textSecondActivity1.text.toString())
        // lad += Entity.Data(KEY_THIRD, textSecondActivity2.text.toString())
        //lad += Entity.Data(KEY_THIRD, textSecondActivity2.text.toString())

        // } else {
        // for (i in lad.indices) {
        //     val ed: Entity.Data = lad.get(i)
        //    if (ed.key.contains("textSecondActivity1"))
        //          textSecondActivity1.text = ed.data
        //      if (ed.key.contains("textSecondActivity2"))
        //           textSecondActivity1.text = ed.data

        //      }

        //  }

        val response: String = "{\"key\":\"KEY_FIRST\",\"data\":\"${KEY_FIRST}\"}"
        // var mEntity = gson?.fromJson(response, Entity.Data::class.java)


    }

    private fun openNewScreen(coll: List<Entity.Data>) {
        val intent = Intent(this, ThirdActivity::class.java)

        for (i in coll.indices) {

            intent.putExtra(coll[i].key, coll[i].data)

        }

        startActivityForResult(intent, 111)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d(TAG, "requestCode = ${requestCode} resultCode = ${resultCode}");
        if (requestCode == 111&& resultCode == Activity.RESULT_OK) {
            response = data?.getStringExtra(KEY_THIRD) as String
            textSecondActivity2.text = response
            Log.d(TAG, "response = ${response}")

        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}