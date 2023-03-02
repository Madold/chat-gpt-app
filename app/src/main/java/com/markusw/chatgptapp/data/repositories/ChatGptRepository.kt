package com.markusw.chatgptapp.data.repositories

import com.markusw.chatgptapp.data.network.remote.responses.ChatResponse

interface ChatGptRepository {
    suspend fun getChatResponse(message: String): ChatResponse?
}