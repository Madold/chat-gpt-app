@file:OptIn(ExperimentalMaterial3Api::class)

package com.markusw.chatgptapp.ui.view.screens.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.markusw.chatgptapp.ui.theme.spacing
import com.markusw.chatgptapp.ui.view.screens.chat.composables.TopBar

@Composable
fun ChatScreen() {
    Scaffold(
        topBar = {
            TopBar(
                title = "Chat GPT App"
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(MaterialTheme.spacing.medium)
            ) {
                Text("Hello World")
            }
        }
    )
}