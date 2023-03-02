package com.markusw.chatgptapp.domain.use_cases

import com.markusw.chatgptapp.domain.ValidationResult
import javax.inject.Inject

class ValidatePrompt @Inject constructor() {

    operator fun invoke(prompt: String): ValidationResult {

        if(prompt.isBlank()) {
            return ValidationResult(
                success = false,
                errorMessage = "Prompt cannot be empty"
            )
        }

        return ValidationResult(success = true)
    }

}