// app/src/main/java/com/example/test_kotlin_cats/ui/cat/CatUiState.kt
package com.example.test_kotlin_cats.ui.cat

data class CatUiState(
    val isLoading: Boolean = false,
    val cats: List<String> = emptyList(),
    val error: String? = null
)

// Можно также хранить Result<List<String>> напрямую вместо трёх полей
