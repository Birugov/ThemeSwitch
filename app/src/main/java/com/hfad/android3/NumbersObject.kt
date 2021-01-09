package com.hfad.android3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object NumbersObject {
    private var _storedNumber = MutableLiveData<Double>()
    private var _action: MutableLiveData<String> = MutableLiveData()
    private var _currentNumber: MutableLiveData<Double> = MutableLiveData()

    val currentNumber: LiveData<Double>
        get() = _currentNumber

    init {
        clear()
    }

    private fun isThereNumber(): Boolean = (_storedNumber.value?.isNaN()?.not()) ?: false

    fun addNumber(number: Double) {
        if (isThereNumber() && number.isNaN().not() && _action.value !== "") {
            when (_action.value) {
                "+" -> {
                    _currentNumber.value = number.plus(_storedNumber.value ?: 0.0)
                    _storedNumber.value = currentNumber.value
                    clearAction()
                }
                "-" -> {
                    _currentNumber.value = (_storedNumber.value ?: 0.0).minus(number)
                    _storedNumber.value = currentNumber.value
                    clearAction()
                }
                "*" -> {
                    _currentNumber.value = (_storedNumber.value ?: 0.0) * number
                    _storedNumber.value = currentNumber.value
                    clearAction()
                }
                "/" -> {
                    if (number.isNaN().not()) {
                        _currentNumber.value = (_storedNumber.value ?: 0.0) / number
                        _storedNumber.value = currentNumber.value
                        clearAction()
                    } else {
                        clear()
                    }
                    clearAction()
                }
            }

        } else {
            clearAction()
            _storedNumber.value = number
            _currentNumber.value = number
        }
    }

    fun addAction(action: String) {
        when (action) {
            "+", "-", "*", "/" -> {
                _action.value = action
            }
            "C" -> {
                clear()
            }
        }
    }

    private fun clear() {
        _currentNumber.value = 0.0
        _storedNumber.value = 0.0
        _action.value = ""
    }

    private fun clearAction() {
        _action.value = ""
    }
}
