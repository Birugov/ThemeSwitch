package com.hfad.android3

import android.view.View

object OnActionClickListener: View.OnClickListener {
    override fun onClick(button: View?) {
        when (button?.id ?: R.id.btn_plus) {
            R.id.btn_plus -> {
                NumbersObject.addAction("+")
            }
            R.id.btn_minus -> {
                NumbersObject.addAction("-")
            }
            R.id.btn_multiplication -> {
                NumbersObject.addAction("*")
            }
            R.id.btn_division -> {
                NumbersObject.addAction("/")
            }
            R.id.btn_c -> {
                NumbersObject.addAction("C")
            }
        }
    }
}
