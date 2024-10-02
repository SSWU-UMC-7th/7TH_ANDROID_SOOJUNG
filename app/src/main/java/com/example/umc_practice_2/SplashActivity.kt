package com.example.umc_practice_2.com.example.umc_practice_2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_practice_2.MainActivity
import com.example.umc_practice_2.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 스플래쉬 화면이 2초 동안 표시된 후 MainActivity로 이동
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // 스플래쉬 액티비티를 종료
        }, 2000) // 2초 동안 스플래쉬 화면 표시
    }
}
