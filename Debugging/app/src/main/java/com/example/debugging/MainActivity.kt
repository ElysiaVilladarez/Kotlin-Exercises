package com.example.debugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logging()
        division()
    }

    fun logging() {
        Log.v(TAG, "Hello, World!")
        Log.e(TAG, "This is an error message")
        Log.d(TAG, "This is an debugging message")
        Log.i(TAG, "This is an info message")
        Log.w(TAG, "This is an warning message")
    }
    fun division() {
        val numerator = 60
        var denominator = 4
        val helloTextView: TextView = findViewById(R.id.division_textview)
        repeat(4) {
            Thread.sleep(3)
            Log.v(TAG, "${numerator/denominator}")
            helloTextView.text = "${numerator/denominator}"
            denominator--
        }
    }
}