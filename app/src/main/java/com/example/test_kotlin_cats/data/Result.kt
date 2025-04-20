// app/src/main/java/com/example/test_kotlin_cats/data/Result.kt
package com.example.test_kotlin_cats.data

sealed class Result<out T> {
    data object Loading : Result<Nothing>()
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
}
