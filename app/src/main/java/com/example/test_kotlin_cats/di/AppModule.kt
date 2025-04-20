// app/src/main/java/com/example/test_kotlin_cats/di/AppModule.kt
package com.example.test_kotlin_cats.di

import com.example.test_kotlin_cats.data.CatRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCatRepository(): CatRepository = CatRepository()
}
