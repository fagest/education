package com.example.smakarov.test7

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

import kotlinx.android.synthetic.main.activity_main.*
/**
 * тестовое задание 7
 * created 24.07.2018 by Sergey V.Makarov
 * email:fagest@yandex.ru
 *
 */
class MainActivity : AppCompatActivity() {

    private lateinit var textFrame:TextView
    private lateinit var imgBlack: ImageView
    private lateinit var imgWhite:ImageView
    private lateinit var frame:ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        textFrame= findViewById (R.id.text_frame)
        frame = findViewById (R.id.frame)
        imgBlack= findViewById (R.id.img_black)
        imgWhite= findViewById (R.id.img_white)
        imgBlack.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        textFrame.text = getString(R.string.action_black)
                        textFrame.setTextColor(Color.BLACK)
                        frame.setBackgroundColor (Color.WHITE)
                    }
                }
        )
        imgWhite.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        textFrame.text = getString(R.string.action_white)
                        textFrame.setTextColor(Color.WHITE)
                        frame.setBackgroundColor (Color.GRAY)
                    }
                }
        )


    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_red -> {
                frame.setBackgroundColor (ContextCompat.getColor(this,R.color.color_red))
                textFrame.text= this.getString(R.string.action_red)
                textFrame.setTextColor(Color.RED)
                true}

            R.id.action_green -> {
                frame.setBackgroundColor(ContextCompat.getColor(this, R.color.color_green))
                textFrame.text= this.getString(R.string.action_green)
                textFrame.setTextColor(Color.GREEN)
                true}

            R.id.action_blue -> {
                frame.setBackgroundColor(ContextCompat.getColor(this,R.color.color_blue))
                textFrame.text= this.getString(R.string.action_blue)
                textFrame.setTextColor(Color.BLUE)
                true}
            else -> super.onOptionsItemSelected(item)
        }
    }
}
