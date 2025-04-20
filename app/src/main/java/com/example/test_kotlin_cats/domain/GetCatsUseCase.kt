// app/src/main/java/com/example/test_kotlin_cats/domain/GetCatsUseCase.kt
package com.example.test_kotlin_cats.domain

import com.example.test_kotlin_cats.data.CatRepository
import com.example.test_kotlin_cats.data.Result
import com.example.test_kotlin_cats.model.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCatsUseCase @Inject constructor(
    private val repo: CatRepository
) {
    operator fun invoke(): Flow<Result<List<Cat>>> =
        repo.getCats().map { result ->
            when (result) {
                is Result.Loading -> Result.Loading
                is Result.Error   -> Result.Error(result.message)
                is Result.Success -> {
                    // конвертим строки в Cat
                    val cats = result.data.map { Cat(it) }
                    Result.Success(cats)
                }
            }
        }
}
