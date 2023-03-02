package com.markusw.chatgptapp.data.network.client

data class CallBody(
    val prompt: String,
    val model: String = "text-davinci-003",
    val max_tokens: Int = 100,
    val temperature: Int = 0,
    val top_p: Int = 1,
    val presence_penalty: Float = 0.0f,
    val frequency_penalty: Float = 0.0f,
)
