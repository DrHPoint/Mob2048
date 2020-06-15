package com.example.mob2048

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var table: Array<Array<Int>> = Array(4) { Array(4) {0} }
        table[0] = arrayOf(0, 0, 0, 0)
        table[1] = arrayOf(0, 0, 0, 0)
        table[2] = arrayOf(0, 0, 0, 0)
        table[3] = arrayOf(0, 0, 0, 0)
        var score = 0

        fun imageScore() {
            textScoreLabel.text = "  " + resources.getString(R.string.text_score) + "  " + score.toString() + "  "
        }

        fun imageTable() {
            textView11.text = table[0][0].toString()
            textView12.text = table[0][1].toString()
            textView13.text = table[0][2].toString()
            textView14.text = table[0][3].toString()
            textView21.text = table[1][0].toString()
            textView22.text = table[1][1].toString()
            textView23.text = table[1][2].toString()
            textView24.text = table[1][3].toString()
            textView31.text = table[2][0].toString()
            textView32.text = table[2][1].toString()
            textView33.text = table[2][2].toString()
            textView34.text = table[2][3].toString()
            textView41.text = table[3][0].toString()
            textView42.text = table[3][1].toString()
            textView43.text = table[3][2].toString()
            textView44.text = table[3][3].toString()
        }

        fun newMove() {
            var rand1 = 0
            for(i in 0..3){
                for(j in 0..3){
                    if (table[i][j] == 0)
                        rand1 += 1
                }
            }
            var rand2 = (0..rand1).shuffled().first()
            rand1 = (1..10).shuffled().first()
            var rand3 = if (rand1 == 10) {
                4
            } else {
                2
            }
            for(i in 0..3){
                for(j in 0..3){
                    if (table[i][j] == 0) {
                        if (rand2 != 0) {
                            rand2 -= 1
                        }
                        else {
                            table[i][j] = rand3
                            rand2 -= 1
                        }
                    }
                }
            }
            imageTable()
        }

        newMove()
        newMove()
        imageScore()

        buttonLeft.setOnClickListener {
            for (i in 0..3) {
                for (j in 0..2) {
                    if (table[i][j] == 0) {
                        table[i][j] = table[i][j+1]
                        table[i][j+1] = 0
                    }
                }
                for (j in 0..1) {
                    if (table[i][j] == 0) {
                        table[i][j] = table[i][j+1]
                        table[i][j+1] = 0
                    }
                }
                if (table[i][0] == 0) {
                    table[i][0] = table[i][1]
                    table[i][1] = 0
                }
                for (j in 0..2) {
                    if (table[i][j] == table[i][j+1]) {
                        table[i][j] *= 2
                        table[i][j+1] = 0
                        score += table[i][j]
                        imageScore()
                    }
                }
                for (j in 0..2) {
                    if (table[i][j] == 0) {
                        table[i][j] = table[i][j+1]
                        table[i][j+1] = 0
                    }
                }
            }
            newMove()
        }

        buttonUp.setOnClickListener {
            for (i in 0..3) {
                for (j in 0..2) {
                    if (table[j][i] == 0) {
                        table[j][i] = table[j+1][i]
                        table[j+1][i] = 0
                    }
                }
                for (j in 0..1) {
                    if (table[j][i] == 0) {
                        table[j][i] = table[j+1][i]
                        table[j+1][i] = 0
                    }
                }
                if (table[0][i] == 0) {
                    table[0][i] = table[1][i]
                    table[1][i] = 0
                }
                for (j in 0..2) {
                    if (table[j][i] == table[j+1][i]) {
                        table[j][i] *= 2
                        table[j+1][i] = 0
                        score += table[j][i]
                        imageScore()
                    }
                }
                for (j in 0..2) {
                    if (table[j][i] == 0) {
                        table[j][i] = table[j+1][i]
                        table[j+1][i] = 0
                    }
                }
            }
            newMove()
        }

        buttonRight.setOnClickListener {
            for (i in 0..3) {
                for (j in 3 downTo 1) {
                    if (table[i][j] == 0) {
                        table[i][j] = table[i][j-1]
                        table[i][j-1] = 0
                    }
                }
                for (j in 3 downTo 2) {
                    if (table[i][j] == 0) {
                        table[i][j] = table[i][j-1]
                        table[i][j-1] = 0
                    }
                }
                if (table[i][3] == 0) {
                    table[i][3] = table[i][2]
                    table[i][2] = 0
                }
                for (j in 3 downTo 1) {
                    if (table[i][j] == table[i][j-1]) {
                        table[i][j] *= 2
                        table[i][j-1] = 0
                        score += table[i][j]
                        imageScore()
                    }
                }
                for (j in 3 downTo 1) {
                    if (table[i][j] == 0) {
                        table[i][j] = table[i][j-1]
                        table[i][j-1] = 0
                    }
                }
            }
            newMove()
        }

        buttonDown.setOnClickListener {
            for (i in 0..3) {
                for (j in 3 downTo 1) {
                    if (table[j][i] == 0) {
                        table[j][i] = table[j-1][i]
                        table[j-1][i] = 0
                    }
                }
                for (j in 3 downTo 2) {
                    if (table[j][i] == 0) {
                        table[j][i] = table[j-1][i]
                        table[j-1][i] = 0
                    }
                }
                if (table[3][i] == 0) {
                    table[3][i] = table[2][i]
                    table[2][i] = 0
                }
                for (j in 3 downTo 1) {
                    if (table[j][i] == table[j-1][i]) {
                        table[j][i] *= 2
                        table[j-1][i] = 0
                        score += table[j][i]
                        imageScore()
                    }
                }
                for (j in 3 downTo 1) {
                    if (table[j][i] == 0) {
                        table[j][i] = table[j-1][i]
                        table[j-1][i] = 0
                    }
                }
            }
            newMove()
        }

    }
}
