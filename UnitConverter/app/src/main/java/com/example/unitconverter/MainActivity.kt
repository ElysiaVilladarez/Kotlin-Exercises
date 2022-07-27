package com.example.unitconverter

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fromSpinner: Spinner = binding.fromUnit
        ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                fromSpinner.adapter = adapter
            }
        fromSpinner.setSelection(0)

        val toSpinner: Spinner = binding.toUnit
        ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                toSpinner.adapter = adapter
            }
        toSpinner.setSelection(1)

        binding.convertButton.setOnClickListener { convert() }
    }

    private fun convert() {
        val value = binding.valueEditText.text.toString().toDouble()
        val fromUnit = binding.fromUnit.selectedItem.toString()
        val toUnit = binding.toUnit.selectedItem.toString()
        val valueResult = when (fromUnit) {
            getString(R.string.ml) -> {
                val finalResult = when (toUnit) {
                    getString(R.string.ounces) -> {
                        val result = value / 29.57
                        result
                    }
                    getString(R.string.grams) -> {
                        value
                    }
                    getString(R.string.cups) -> {
                        val result = value / 250.0
                        result
                    }
                    else -> {
                        0.0
                    }
                }
                finalResult
            }
            getString(R.string.ounces) -> {
                val finalResult = when (toUnit) {
                    getString(R.string.ml) -> {
                        val result = value * 29.57
                        result
                    }
                    getString(R.string.grams) -> {
                        val result = value * 28.35
                        result
                    }
                    getString(R.string.cups) -> {
                        val result = value / 8
                        result
                    }
                    else -> {
                        0.0
                    }
                }
                finalResult
            }
            getString(R.string.grams) -> {
                val finalResult = when (toUnit) {
                    getString(R.string.ml) -> {
                        value
                    }
                    getString(R.string.ounces) -> {
                        val result = value / 28.35
                        result
                    }
                    getString(R.string.cups) -> {
                        val result = value / 250.0
                        result
                    }
                    else -> {
                        0.0
                    }
                }
                finalResult
            }
            getString(R.string.cups) -> {
                val finalResult = when (toUnit) {
                    getString(R.string.ml) -> {
                        val result = value * 250.0
                        result
                    }
                    getString(R.string.ounces) -> {
                        val result = value * 8
                        result
                    }
                    getString(R.string.grams) -> {
                        val result = value * 250.0
                        result
                    }
                    else -> {
                        0.0
                    }
                }
                finalResult
            }
            else -> 0.0
        }
        binding.textviewResult.text = valueResult.toString()
    }
}
