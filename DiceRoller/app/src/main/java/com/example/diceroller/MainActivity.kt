package com.example.diceroller

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }

        //Do a dice roll when the app starts
        rollDice()
    }

    /**
    *Roll the dice and update the screen with the result
    */
    private fun rollDice() {
        //Create a new Dice objects with 6 and 12 sides and roll the dices
        val dice = Dice(6)
        val diceSecond = Dice(6)

        val diceRoll = dice.roll()
        val diceRollSecond = diceSecond.rollSecond()

        //Find the ImageView in the Layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        val diceImageSecond: ImageView = findViewById(R.id.imageView2)

        //Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResourceSecond = when (diceRollSecond) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Update the ImageView with correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        diceImageSecond.setImageResource(drawableResourceSecond)

        //Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImageSecond.contentDescription = diceRoll.toString()
    }

    class Dice(val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }

        fun rollSecond(): Int {
            return (1..numSides).random()
        }
    }
}

