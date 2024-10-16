package com.example.umc_study_week4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvTimer: TextView
    private lateinit var btnStartPause: Button
    private lateinit var btnClear: Button

    private var timeInMillis = 0L
    private var isRunning = false
    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTimer = findViewById(R.id.tv_timer)
        btnStartPause = findViewById(R.id.btn_start_pause)
        btnClear = findViewById(R.id.btn_clear)

        btnStartPause.text = "Start" // 앱이 처음 실행될 때 "Start"로 설정

        btnStartPause.setOnClickListener {
            if (!isRunning) {
                startTimer()
                btnStartPause.text = "Pause" // 타이머가 시작되면 "Pause"로 변경
            } else {
                pauseTimer()
                btnStartPause.text = "Start" // 타이머가 멈추면 "Start"로 변경
            }
        }

        btnClear.setOnClickListener {
            clearTimer()
        }
    }

    private fun startTimer() {
        isRunning = true
        job = CoroutineScope(Dispatchers.Main).launch {
            while (isRunning) {
                delay(10L)
                timeInMillis += 10
                updateTimerText()
            }
        }
    }

    private fun pauseTimer() {
        isRunning = false
        job?.cancel()
    }

    private fun clearTimer() {
        pauseTimer() // 타이머를 일시정지
        timeInMillis = 0L
        updateTimerText()
        // Clear 버튼을 눌러도 Start 버튼의 텍스트는 유지됨
    }

    private fun updateTimerText() {
        val minutes = (timeInMillis / 1000) / 60
        val seconds = (timeInMillis / 1000) % 60
        val milliseconds = (timeInMillis % 1000) / 10

        tvTimer.text = String.format("%02d:%02d,%02d", minutes, seconds, milliseconds)
    }
}

