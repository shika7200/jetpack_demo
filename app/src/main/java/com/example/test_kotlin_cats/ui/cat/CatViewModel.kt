// app/src/main/java/com/example/test_kotlin_cats/ui/cat/CatViewModel.kt
package com.example.test_kotlin_cats.ui.cat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_kotlin_cats.data.Result
import com.example.test_kotlin_cats.domain.GetCatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(
    private val getCatsUseCase: GetCatsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CatUiState())
    val state: StateFlow<CatUiState> = _state

    init {
        viewModelScope.launch {
            getCatsUseCase().collect { result ->
                _state.update { old ->
                    when (result) {
                        is Result.Loading -> old.copy(isLoading = true, error = null)
                        is Result.Success -> old.copy(
                            isLoading = false,
                            cats = result.data,
                            error = null
                        )
                        is Result.Error -> old.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }
}
