package com.markusw.chatgptapp.data.network.services

import com.markusw.chatgptapp.data.network.client.CallBody
import com.markusw.chatgptapp.data.network.client.ChatGptClient
import com.markusw.chatgptapp.data.network.remote.responses.ChatResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ChatGptService @Inject constructor(
    private val chatGptApi: ChatGptClient
) {

    suspend fun getChatResponse(message: String): ChatResponse? {
        return withContext(Dispatchers.IO) {
            val response = chatGptApi.getChatResponse(
                body = CallBody(
                    prompt = message
                )
            )
            response.getOrNull()
        }
    }

}