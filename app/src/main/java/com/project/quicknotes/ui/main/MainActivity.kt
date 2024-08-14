package com.project.quicknotes.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.quicknotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAction()
    }

    private fun setAction() {
        with(binding) {

        }
    }
}