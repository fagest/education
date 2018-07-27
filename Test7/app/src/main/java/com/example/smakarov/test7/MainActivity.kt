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
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
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
   // private lateinit var imgBlack: ImageView
   // private lateinit var imgWhite:ImageView
    private lateinit var frame:ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        textFrame = findViewById (R.id.text_frame)
        frame = findViewById (R.id.frame)
        /*
         imgBlack= findViewById (R.id.img_black)
       imgWhite= findViewById (R.id.img_white)
        imgBlack.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        changeColor(MenuColor.BLACK)
                                   }
                }
        )
        imgWhite.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        changeColor(MenuColor.WHITE)
                       }
                }
        )
        */
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_black -> {
                changeColor(MenuColor.BLACK)
                true}
            R.id.action_white -> {
                changeColor(MenuColor.WHITE)
                true}
            R.id.action_red -> {
                changeColor(MenuColor.RED)
                true}

            R.id.action_green -> {
                changeColor(MenuColor.GREEN)
                 true}

            R.id.action_blue -> {
                changeColor(MenuColor.BLUE)
                true}
            else -> super.onOptionsItemSelected(item)
        }
    }

    enum class MenuColor(@StringRes val colorNameResId :Int,
                         @ColorRes val backgroundColorsId :Int,
                         @ColorRes val textColorResId :Int

    ){
        BLACK(R.string.action_black,R.color.color_black_background,R.color.color_black_text),
        WHITE (R.string.action_white,R.color.color_white_background,R.color.color_white_text),
        RED (R.string.action_red,R.color.color_red_background,R.color.color_red_text),
        GREEN (R.string.action_green,R.color.color_green_background,R.color.color_green_text),
        BLUE (R.string.action_blue,R.color.color_blue_background,R.color.color_blue_text)
    }

    fun changeColor(menuColor:MenuColor){
        frame.setBackgroundColor(ContextCompat.getColor(this,menuColor.backgroundColorsId))
        textFrame.text= this.getString(menuColor.colorNameResId)
        textFrame.setTextColor(ContextCompat.getColor(this,menuColor.textColorResId))

    }

}
