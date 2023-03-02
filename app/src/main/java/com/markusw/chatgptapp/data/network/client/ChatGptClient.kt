package com.markusw.chatgptapp.data.network.client

import com.markusw.chatgptapp.data.network.remote.responses.ChatResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatGptClient {
    @POST
    suspend fun getChatResponse(@Body body: CallBody): Result<ChatResponse>
}

