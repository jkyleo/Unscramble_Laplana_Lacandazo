
package com.example.unscramble1

data class GameUiState(
    val currentWord: String = "CAT",
    val score: Int = 0,
    val userAnswer: String = ""
)