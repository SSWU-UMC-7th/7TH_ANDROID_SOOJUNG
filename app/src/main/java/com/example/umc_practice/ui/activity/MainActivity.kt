package com.example.umc_practice.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_practice.databinding.ActivityMainBinding
import com.example.umc_practice.ui.adapter.EmotionAdapter
import com.example.umc_practice.ui.viewmodel.EmotionViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val emotionViewModel: EmotionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        emotionViewModel.items.observe(this, { items ->
            binding.recyclerView.adapter = EmotionAdapter(items)
        })
    }
}
