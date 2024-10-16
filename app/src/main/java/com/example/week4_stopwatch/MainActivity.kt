package com.example.week4_stopwatch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvTime: TextView
    private lateinit var btnStartPause: Button
    private lateinit var btnClear: Button

    private var time = 0L // 스톱워치 경과 시간 (밀리초 단위)
    private var isRunning = false // 스톱워치 실행 상태
    private var job: Job? = null // 코루틴 작업 관리

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI 요소 연결
        tvTime = findViewById(R.id.tvTime)
        btnStartPause = findViewById(R.id.btnStartPause)
        btnClear = findViewById(R.id.btnClear)

        // Start/Pause 버튼 클릭 이벤트 처리
        btnStartPause.setOnClickListener {
            if (isRunning) {
                pauseStopwatch() // 실행 중일 때는 일시정지
            } else {
                startStopwatch() // 멈춰있을 때는 시작
            }
        }

        // Clear 버튼 클릭 이벤트 처리
        btnClear.setOnClickListener {
            clearStopwatch() // 시간 초기화
        }
    }

    // 스톱워치 시작 함수
    private fun startStopwatch() {
        isRunning = true
        btnStartPause.text = "Pause"
        job = CoroutineScope(Dispatchers.Main).launch {
            while (isRunning) {
                delay(10L) // 10밀리초마다 시간 갱신
                time += 10L
                updateTimerText()
            }
        }
    }

    // 스톱워치 일시정지 함수
    private fun pauseStopwatch() {
        isRunning = false
        btnStartPause.text = "Start"
        job?.cancel() // 코루틴 작업 취소
    }

    // 스톱워치 초기화 함수
    private fun clearStopwatch() {
        time = 0L
        updateTimerText() // 시간 0으로 갱신
        if (!isRunning) { // 일시정지 상태라면 초기화 후 정지 유지
            pauseStopwatch()
        }
    }

    // 시간 표시 업데이트 함수
    private fun updateTimerText() {
        val minutes = (time / 1000) / 60
        val seconds = (time / 1000) % 60
        val milliseconds = (time % 1000) / 10
        tvTime.text = String.format("%02d:%02d,%02d", minutes, seconds, milliseconds)
    }
}
