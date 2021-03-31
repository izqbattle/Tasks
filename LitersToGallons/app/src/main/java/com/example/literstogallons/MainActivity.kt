package com.example.literstogallons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.literstogallons.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateValue() }
    }

    private fun calculateValue() {
        val stringInTextFiled = binding.literValue.text.toString()

        val value = stringInTextFiled.toDoubleOrNull()
        if (value == null || value == 0.0) {
            binding.valueResult.text = ""
            return
        }

        val valueDefinition = when (binding.definitionOptions.checkedRadioButtonId) {
            R.id.USA -> 3.78541
            R.id.EN -> 4.546
            else -> 3.8
        }
        var result = value / valueDefinition
        if (binding.roundUpSwitch.isChecked) {
            result = String.format("%.2f", result).toDouble()
        }

        binding.valueResult.text = "Gallons Amount: ${result.toString()}"
    }
}