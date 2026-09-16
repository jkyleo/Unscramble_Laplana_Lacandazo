
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
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

    // Get the ViewModel
    val viewModel: GameViewModel = viewModel()

    // Get the current correct answer
    val correctAnswer =
        viewModel.words[viewModel.currentWordIndex]

    // Display the game UI
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "UNSCRAMBLE",
            fontSize = 30.sp
        )

        // Display the current word
        Text(
            text = correctAnswer,
            fontSize = 40.sp
        )

        Text(
            text = "Unscramble the word!"
        )

        // Read the answer from the ViewModel
        OutlinedTextField(
            value = viewModel.userAnswer,
            onValueChange = {
                viewModel.userAnswer = it
            },
            label = {
                Text("Enter your answer")
            }
        )

        Button(
            onClick = {
                // Game logic will be moved
                // into the ViewModel in a later phase.
            }
        ) {
            Text("SUBMIT")
        }

        // Display the ViewModel score
        Text(
            text = "Score: ${viewModel.score}"
        )
    }
}