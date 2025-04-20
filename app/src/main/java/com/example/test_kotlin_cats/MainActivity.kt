package com.example.test_kotlin_cats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.test_kotlin_cats.ui.cat.CatScreen
import com.example.test_kotlin_cats.ui.theme.Test_kotlin_catsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Test_kotlin_catsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CatScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
