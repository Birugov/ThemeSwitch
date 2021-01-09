package com.hfad.android3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var themeManager: ThemeManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        themeManager = ThemeManager(this.applicationContext)

        subscribeObservers()

        btn_zero.setOnClickListener (OnNumberClickListener)
        btn_one.setOnClickListener(OnNumberClickListener)
        btn_two.setOnClickListener(OnNumberClickListener)
        btn_three.setOnClickListener(OnNumberClickListener)
        btn_four.setOnClickListener(OnNumberClickListener)
        btn_five.setOnClickListener(OnNumberClickListener)
        btn_six.setOnClickListener(OnNumberClickListener)
        btn_seven.setOnClickListener(OnNumberClickListener)
        btn_eight.setOnClickListener(OnNumberClickListener)
        btn_nine.setOnClickListener(OnNumberClickListener)
        print(45)
        btn_plus.setOnClickListener(OnActionClickListener)
        btn_minus.setOnClickListener(OnActionClickListener)
        btn_multiplication.setOnClickListener(OnActionClickListener)
        btn_division.setOnClickListener(OnActionClickListener)
        btn_c.setOnClickListener(OnActionClickListener)

        if (themeManager.fetchTheme() != null) {
            when(themeManager.fetchTheme()) {
                Constants.NIGHT_MODE_YES -> {
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
                }
                Constants.NIGHT_MODE_NO -> {
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
                }
            }
        }

        btn_change_theme.setOnClickListener {
            if (AppCompatDelegate.getDefaultNightMode() == MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
                themeManager.saveTheme(Constants.NIGHT_MODE_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
                themeManager.saveTheme(Constants.NIGHT_MODE_YES)
            }
        }
    }

    private fun subscribeObservers() {
        NumbersObject.currentNumber.observe(this) { currentNumber ->
            tv_result.text = currentNumber.toString()
        }
    }
}
