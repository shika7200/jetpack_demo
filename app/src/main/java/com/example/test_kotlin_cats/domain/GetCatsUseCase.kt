// app/src/main/java/com/example/test_kotlin_cats/domain/GetCatsUseCase.kt
package com.example.test_kotlin_cats.domain

import com.example.test_kotlin_cats.data.CatRepository
import com.example.test_kotlin_cats.data.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCatsUseCase @Inject constructor(
    private val repo: CatRepository
) {
    operator fun invoke(): Flow<Result<List<String>>> = repo.getCats()
}
