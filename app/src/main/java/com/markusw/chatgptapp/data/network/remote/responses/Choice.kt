package com.markusw.chatgptapp.data.network.remote.responses

data class Choice(
    val finish_reason: String,
    val index: Int,
    val message: Message
)