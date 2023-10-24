package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var xTurn = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val turnDisplay = findViewById<TextView>(R.id.TurnDisplay)
        val ticTacToeButtons = arrayOf(
            findViewById<Button>(R.id.GameButton1_1),
            findViewById<Button>(R.id.GameButton1_2),
            findViewById<Button>(R.id.GameButton1_3),
            findViewById<Button>(R.id.GameButton2_1),
            findViewById<Button>(R.id.GameButton2_2),
            findViewById<Button>(R.id.GameButton2_3),
            findViewById<Button>(R.id.GameButton3_1),
            findViewById<Button>(R.id.GameButton3_2),
            findViewById<Button>(R.id.GameButton3_3),
        )
        for(button in ticTacToeButtons) {
            button.setOnClickListener {
                buttonClick(button, turnDisplay)
            }
        }
        val newGame = findViewById<Button>(R.id.NewGame)
        newGame.setOnClickListener {
            for(button in ticTacToeButtons) {
                button.text = ""
                button.isEnabled = true
            }
            turnDisplay.text = "X's Turn"
            xTurn = true
        }
    }
    fun buttonClick(button: Button, turnDisplay: TextView) {
        if (xTurn) {
            button.text = "X"
            turnDisplay.text = "O's Turn"
        } else {
            button.text = "O"
            turnDisplay.text = "X's Turn"
        }
        xTurn = !xTurn
        button.isEnabled = false
    }
}