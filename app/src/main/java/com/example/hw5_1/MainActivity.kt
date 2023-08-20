package com.example.hw5_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hw5_1.databinding.ActivityMainBinding
import com.example.hw5_1.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {

    private lateinit var binding: ActivityMainBinding
    private var presenter = Presenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()
    }

    private fun initListener() = with(binding) {
        btnIncrement.setOnClickListener {
            presenter.increment()
        }

        btnDecrement.setOnClickListener {
            presenter.decrement()
        }
    }

    override fun showCount(number: Int) {
        binding.tvCount.text = number.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeColor(color: Int) {
        binding.tvCount.setTextColor(getColor(color))
    }

}