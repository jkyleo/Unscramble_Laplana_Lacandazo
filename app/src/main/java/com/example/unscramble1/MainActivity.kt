package com.example.unscramble1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.unscramble1.ui.theme.Unscramble1Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Unscramble1Theme {
                GameScreen()
            }
        }
    }
}

@Composable
fun GameScreen() {

    // Stores the answer typed by the user
    var userAnswer by remember {
        mutableStateOf("")
    }

    // List of words
    val words: List<String> = listOf(
        "CAT",
        "DOG",
        "BOOK"
    )

    // Keeps track of the current word
    var currentWordIndex by remember {
        mutableStateOf(0)
    }

    // Gets the correct answer
    val correctAnswer: String = words[currentWordIndex]

    // Creates the first scrambled word
    var scrambledWord by remember {
        mutableStateOf(
            words[0]
                .toList()
                .shuffled()
                .joinToString("")
        )
    }

    // Stores the player's score
    var score by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "UNSCRAMBLE",
            fontSize = 30.sp
        )

        Text(
            text = scrambledWord,
            fontSize = 40.sp
        )

        Text(
            text = "Unscramble the word!"
        )

        OutlinedTextField(
            value = userAnswer,
            onValueChange = {
                userAnswer = it
            },
            label = {
                Text("Enter your answer")
            }
        )

        Button(
            onClick = {

                // Check the user's answer
                if (userAnswer.uppercase() == correctAnswer) {

                    // Increase score
                    score++

                    // Check if another word is available
                    if (currentWordIndex < words.size - 1) {

                        // Move to the next word
                        currentWordIndex++

                        // Clear the TextField
                        userAnswer = ""

                        // Scramble the next word
                        scrambledWord = words[currentWordIndex]
                            .toList()
                            .shuffled()
                            .joinToString("")
                    }
                }
            }
        ) {
            Text("SUBMIT")
        }

        Text(
            text = "Score: $score"
        )
    }
}