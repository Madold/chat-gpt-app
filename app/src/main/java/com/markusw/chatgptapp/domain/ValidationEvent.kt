package com.markusw.chatgptapp.domain

sealed class ValidationEvent {
    object Success: ValidationEvent()
    data class Failure(val reason: String): ValidationEvent()
}
