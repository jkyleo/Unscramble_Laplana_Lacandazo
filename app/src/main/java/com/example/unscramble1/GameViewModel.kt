
package com.example.unscramble1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    private val words: List<String> = listOf("CAT", "DOG", "BOOK")

    private var currentWordIndex = 0

    private val _uiState = MutableStateFlow(
        GameUiState(
            currentWord = words[currentWordIndex]
        )
    )

    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun updateUserAnswer(answer: String) {
        _uiState.value = _uiState.value.copy(
            userAnswer = answer
        )
    }
}