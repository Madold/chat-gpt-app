package com.markusw.chatgptapp.data.network.client

import com.markusw.chatgptapp.data.network.remote.responses.ChatResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatGptClient {
    @POST
    suspend fun getChatResponse(@Body body: CallBody): Result<ChatResponse>
}

data class CallBody(
    val prompt: String,
    val model: String = "text-davinci-003",
    val max_tokens: Int = 100,
    val temperature: Int = 0,
    val top_p: Int = 1,
    val presence_penalty: Float = 0.0f,
    val frequency_penalty: Float = 0.0f,
)
