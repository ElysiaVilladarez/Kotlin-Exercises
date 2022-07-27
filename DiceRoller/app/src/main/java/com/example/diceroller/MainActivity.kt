package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button);
        val toast: Toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT);
        rollButton.setOnClickListener {
            // toast.show()
            rollDice()
        }
    }

    private fun rollDice() {
        val myDice = Dice(6)
        val rolledNum1 = myDice.roll()
        val rolledNum2 = myDice.roll()
        val diceImage1: ImageView = findViewById(R.id.dice1)
        val diceImage2: ImageView = findViewById(R.id.dice2)

        diceImage1.setImageResource(getResource(rolledNum1))
        diceImage1.contentDescription = rolledNum1.toString()
        diceImage2.setImageResource(getResource(rolledNum2))
        diceImage2.contentDescription = rolledNum2.toString()
    }
    private fun getResource(rolledNum: Int): Int {
        return when (rolledNum) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

//    private fun luckRoll(diceNum: Int, luckyNum: Int) {
//        val myDice = Dice(6)
//        val rolledNum: Int = myDice.roll()
//        val announcementTextView: TextView = findViewById(R.id.announcement)
//        if (rolledNum == luckyNum) announcementTextView.text = "You won!"
//        else announcementTextView.text = "You lost :("
//    }

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}