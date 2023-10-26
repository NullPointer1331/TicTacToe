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
                checkWin(ticTacToeButtons)
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
    fun checkWin(buttons: Array<Button>) {
        // Check tie
        var tie = true
        for(button in buttons) {
            if(button.text == "") {
                tie = false
                break
            }
        }
        if(tie) {
            val turnDisplay = findViewById<TextView>(R.id.TurnDisplay)
            turnDisplay.text = "It's a tie!"
            return
        }
        // Check vertical
        for(i in 0..2) {
            if(buttons[i].text == buttons[i+3].text && buttons[i].text == buttons[i+6].text) {
                if(buttons[i].text == "X") {
                    win("X", buttons)
                    return
                } else if(buttons[i].text == "O") {
                    win("O", buttons)
                    return
                }
            }
        }
        // Check horizontal
        for (i in 0..6 step 3) {
            if(buttons[i].text == buttons[i+1].text && buttons[i].text == buttons[i+2].text) {
                if(buttons[i].text == "X") {
                    win("X", buttons)
                    return
                } else if(buttons[i].text == "O") {
                    win("O", buttons)
                    return
                }
            }
        }
        // Check diagonal
        if(buttons[0].text == buttons[4].text && buttons[0].text == buttons[8].text) {
            if(buttons[0].text == "X") {
                win("X", buttons)
                return
            } else if(buttons[0].text == "O") {
                win("O", buttons)
                return
            }
        }
        if(buttons[2].text == buttons[4].text && buttons[2].text == buttons[6].text) {
            if(buttons[2].text == "X") {
                win("X", buttons)
                return
            } else if(buttons[2].text == "O") {
                win("O", buttons)
                return
            }
        }
    }
    fun win(winner: String, buttons: Array<Button>) {
        val turnDisplay = findViewById<TextView>(R.id.TurnDisplay)
        turnDisplay.text = "$winner wins!"
        for(button in buttons) {
            button.isEnabled = false
        }
    }
}