package com.markusw.chatgptapp.ui.view.screens.chat

import com.markusw.chatgptapp.data.model.chat.ChatMessage

data class UiState(
    val userPrompt: String = "",
    val userPromptError: String? = null,
    var chatList: List<ChatMessage> = emptyList(),
    val isLoading: Boolean = false,
)
