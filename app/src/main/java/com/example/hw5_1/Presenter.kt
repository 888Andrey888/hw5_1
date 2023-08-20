package com.example.hw5_1

import com.example.hw5_1.model.CounterModel
import com.example.hw5_1.view.CounterView

class Presenter(private val view: CounterView) {

    private val model = CounterModel()

    fun increment() {
        model.increment()
        showToast()
        changeColor()
        view.showCount(model.number)
    }

    fun decrement() {
        model.decrement()
        showToast()
        changeColor()
        view.showCount(model.number)
    }

    private fun showToast() {
        if (model.number == 10) {
            view.showToast("Поздравляем")
        }
    }

    private fun changeColor() {
        if (model.number in -15..15){
            view.changeColor(R.color.black)
        }else{
            view.changeColor(R.color.green)
        }
    }
}