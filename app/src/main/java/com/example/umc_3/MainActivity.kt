package com.example.umc_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_3.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var time = 0L
    private var job: Job? = null
    private var isPaused = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start 버튼 클릭 리스너 설정
        binding.btnStart.setOnClickListener {
            if (job == null || job?.isCancelled == true) {
                startTimer()
                binding.btnClear.isEnabled = true
            }
        }

        // Clear 버튼 클릭 리스너 설정
        binding.btnClear.setOnClickListener {
            clearTimer()
            binding.btnClear.isEnabled = false
        }
    }

    // 타이머 시작 함수
    private fun startTimer() {
        isPaused = false
        job = CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                delay(1000L)
                if (!isPaused) {
                    time++
                    updateTimerUI(time)
                }
            }
        }
    }

    // 타이머 초기화 함수
    private fun clearTimer() {
        job?.cancel()
        time = 0L
        updateTimerUI(time)
    }

    // UI 업데이트 함수
    private fun updateTimerUI(time: Long) {
        val seconds = time % 60
        val minutes = (time / 60) % 60
        val hours = (time / 3600)
        binding.timerTextView.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)

        // 디버깅을 위한 로그
        println("Timer Updated: $hours:$minutes:$seconds")
    }
}
