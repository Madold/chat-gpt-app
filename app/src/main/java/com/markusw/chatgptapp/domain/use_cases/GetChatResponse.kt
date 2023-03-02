package com.markusw.chatgptapp.domain.use_cases

import com.markusw.chatgptapp.data.model.chat.ChatMessage
import com.markusw.chatgptapp.data.repositories.ChatRepositoryImpl
import javax.inject.Inject

class GetChatResponse @Inject constructor(
    private val repository: ChatRepositoryImpl
) {

    suspend operator fun invoke(prompt: String): ChatMessage {
        val response = repository.getChatResponse(prompt)

        return response?.let {
            ChatMessage(
                content = it.choices[0].message.content,
                owner = "bot"
            )
        } ?: ChatMessage(
            content = "Something went wrong",
            owner = "bot"
        )
    }

}