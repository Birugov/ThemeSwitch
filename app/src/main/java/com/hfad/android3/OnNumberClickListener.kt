package com.hfad.android3

import android.view.View

object OnNumberClickListener: View.OnClickListener {
    override fun onClick(button: View?) {
        when (button?.id ?: R.id.btn_zero) {
            R.id.btn_zero -> {
                NumbersObject.addNumber(0.0)
            }
            R.id.btn_one -> {
                NumbersObject.addNumber(1.0)
            }
            R.id.btn_two -> {
                NumbersObject.addNumber(2.0)
            }
            R.id.btn_three -> {
                NumbersObject.addNumber(3.0)
            }
            R.id.btn_four -> {
                NumbersObject.addNumber(4.0)
            }
            R.id.btn_five -> {
                NumbersObject.addNumber(5.0)
            }
            R.id.btn_six -> {
                NumbersObject.addNumber(6.0)
            }
            R.id.btn_seven -> {
                NumbersObject.addNumber(7.0)
            }
            R.id.btn_eight -> {
                NumbersObject.addNumber(8.0)
            }
            R.id.btn_nine -> {
                NumbersObject.addNumber(9.0)
            }
        }
    }
}
