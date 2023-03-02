package com.markusw.chatgptapp.data.repositories

import com.markusw.chatgptapp.data.network.remote.responses.ChatResponse
import com.markusw.chatgptapp.data.network.services.ChatGptService
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val service: ChatGptService
) : ChatGptRepository {

    override suspend fun getChatResponse(message: String): ChatResponse? {
        return service.getChatResponse(message)
    }

}