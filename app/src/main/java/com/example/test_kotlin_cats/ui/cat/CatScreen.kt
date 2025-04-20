package com.example.test_kotlin_cats.ui.cat

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CatScreen(
    modifier: Modifier = Modifier ,
    vm: CatViewModel = hiltViewModel(),
           // ← добавили параметр modifier
) {
    val uiState by vm.state.collectAsStateWithLifecycle()

    when {
        uiState.isLoading -> {
            Box(
                modifier = modifier.fillMaxSize(),  // используем прокинутый modifier
                contentAlignment = Alignment.Center
            ) {
                Text("Loading...")
            }
        }
        uiState.error != null -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Error: ${uiState.error}")
            }
        }
        else -> {
            LazyColumn(modifier = modifier.fillMaxSize()) {
                items(uiState.cats) { cat ->
                    Text(
                        text = "Cat: $cat",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}
