package com.markusw.chatgptapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.markusw.chatgptapp.domain.ValidationEvent
import com.markusw.chatgptapp.domain.use_cases.GetChatResponse
import com.markusw.chatgptapp.domain.use_cases.ValidatePrompt
import com.markusw.chatgptapp.ui.view.screens.chat.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatScreenViewModel @Inject constructor(
    private val getChatResponse: GetChatResponse,
    private val validatePrompt: ValidatePrompt,
) : ViewModel() {

    private var _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()
    /*
    private val channel = Channel<ValidationEvent>()
    val validationEventChannel = channel.receiveAsFlow()*/

    fun onPromptChanged(prompt: String) {
        _uiState.update { it.copy(userPrompt = prompt) }
    }

    fun onSendClicked() {
        viewModelScope.launch {

            val promptValidationResult = validatePrompt(uiState.value.userPrompt)

            if(!promptValidationResult.success) {
                _uiState.update { it.copy(userPromptError = promptValidationResult.errorMessage) }
                return@launch
            }

            _uiState.update { it.copy(isLoading = true) }
            val response = getChatResponse(uiState.value.userPrompt)
            _uiState.update { it.copy(chatList = it.chatList + response) }
            _uiState.update { it.copy(isLoading = false) }
        }
    }

    private fun resetUiState() {
        _uiState.update { UiState() }
    }

}