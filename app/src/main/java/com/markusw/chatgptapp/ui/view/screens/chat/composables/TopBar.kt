@file:OptIn(ExperimentalMaterial3Api::class)

package com.markusw.chatgptapp.ui.view.screens.chat.composables

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun TopBar(
    title: String,
) {
    TopAppBar(
        title = { Text(text = title) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.onSurface,
            titleContentColor = MaterialTheme.colorScheme.surface,
        )
    )
}