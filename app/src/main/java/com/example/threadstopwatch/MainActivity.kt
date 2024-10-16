package com.example.threadstopwatch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import com.example.threadstopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var job: Job? = null
    private var time = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start/Pause 버튼 눌렀을 때
        binding.btnPause.setOnClickListener {
            if (job?.isActive == true) {
                job?.cancel()
                binding.btnPause.text = "Start"
            } else {
                job = startTimer()
                binding.btnPause.text = "Pause"
            }
        }

        // Clear 버튼 눌렀을 때
        binding.btnClear.setOnClickListener {
            job?.cancel()
            time = 0
            binding.tvTime.text = "00:00:00"
            binding.btnPause.text = "Start"  // 'Clear' 버튼을 누르면 'Start'로 리셋
        }
    }

    private fun startTimer() = lifecycleScope.launch(Dispatchers.Main) {
        while (isActive) {
            time++
            binding.tvTime.text = String.format("%02d:%02d:%02d", time / 600, (time / 10) % 60, time % 10)
            delay(100)
        }
    }
}
