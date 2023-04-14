package com.example.day20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.day20.databinding.ActivityLoginBinding
import com.example.day20.databinding.ActivityWellomeBinding

class Wellome : AppCompatActivity() {
    lateinit var binding: ActivityWellomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWellomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        

    }
}