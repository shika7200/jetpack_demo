// app/src/main/java/com/example/test_kotlin_cats/data/CatRepository.kt
package com.example.test_kotlin_cats.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CatRepository @Inject constructor() {
    fun getCats(): Flow<Result<List<String>>> = flow {
        emit(Result.Loading)
        delay(2000)
        val success = true
        if (success) {
            emit(Result.Success(listOf("Whiskers", "Mittens", "Garfield")))
        } else {
            emit(Result.Error("Unable to fetch cats"))
        }
    }
}
