// app/src/main/java/com/example/test_kotlin_cats/ui/cat/CatUiState.kt
package com.example.test_kotlin_cats.ui.cat

import com.example.test_kotlin_cats.model.Cat

data class CatUiState(
    val isLoading: Boolean = false,
    val cats: List<Cat> = emptyList(),
    val error: String? = null
)

// Можно также хранить Result<List<String>> напрямую вместо трёх полей
