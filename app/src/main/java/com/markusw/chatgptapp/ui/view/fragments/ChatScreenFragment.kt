package com.markusw.chatgptapp.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import com.markusw.chatgptapp.R
import com.markusw.chatgptapp.databinding.FragmentChatScreenBinding
import com.markusw.chatgptapp.ui.theme.AppTheme
import com.markusw.chatgptapp.ui.view.screens.chat.ChatScreen

class ChatScreenFragment : Fragment() {

    private lateinit var composeView: ComposeView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).also {
            composeView = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        composeView.setContent {
            AppTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ChatScreen()
                }
            }
        }
    }

}