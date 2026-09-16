
package com.example.unscramble1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                GameScreen()
            }
        }
    }
}

@androidx.compose.runtime.Composable
fun GameScreen(
    viewModel: GameViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Unscramble",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Word: ${uiState.currentWord}",
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "Score: ${uiState.score}",
            modifier = Modifier.padding(top = 8.dp)
        )


        OutlinedTextField(
            value = uiState.userAnswer,
            onValueChange = { viewModel.updateUserAnswer(it) },
            label = { Text("Your answer") },
            modifier = Modifier.padding(top = 16.dp)
        )

        Button(
            onClick = {},
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Submit")
        }
    }
}