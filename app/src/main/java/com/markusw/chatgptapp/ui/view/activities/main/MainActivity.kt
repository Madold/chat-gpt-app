package com.markusw.chatgptapp.ui.view.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.markusw.chatgptapp.R
import com.markusw.chatgptapp.databinding.ActivityMainBinding
import com.orhanobut.logger.Logger
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Logger.d("Application started")
    }
}