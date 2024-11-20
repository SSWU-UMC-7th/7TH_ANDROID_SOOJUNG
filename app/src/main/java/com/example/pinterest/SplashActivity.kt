package com.example.pinterest

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Splash 화면의 레이아웃 설정 (다음에 설명할 XML 레이아웃을 연결)
        setContentView(R.layout.activity_splash)

        // 3초 동안 Splash 화면을 보여준 후 메인 화면으로 전환
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Splash 화면을 종료하여 뒤로 가기 버튼으로 돌아가지 않게 함
        }, 3000)
    }
}