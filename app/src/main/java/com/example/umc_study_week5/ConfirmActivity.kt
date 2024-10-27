package com.example.umc_study_week5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_study_week5.databinding.ActivityConfirmBinding

class ConfirmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val memo = intent.getStringExtra("memo")
        binding.memoTextView.text = memo
    }
}

