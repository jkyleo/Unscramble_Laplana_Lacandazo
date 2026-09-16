
package com.example.unscramble1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // List of game words
    val words: List<String> = listOf(
        "CAT",
        "DOG",
        "BOOK"
    )

    // Current word position
    var currentWordIndex by mutableIntStateOf(0)

    // Player's score
    var score by mutableIntStateOf(0)

    // Answer entered by the player
    var userAnswer by mutableStateOf("")
}
