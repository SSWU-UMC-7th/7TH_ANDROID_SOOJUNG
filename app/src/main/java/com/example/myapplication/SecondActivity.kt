package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 전달받은 감정 텍스트와 이미지 리소스를 가져옴
        val emotionText = intent.getStringExtra("emotion_text")
        val emotionImageResId = intent.getIntExtra("emotion_image", 0)

        // UI에 텍스트와 이미지 설정
        val emotionTextView: TextView = findViewById(R.id.selectedEmotionText)
        val emotionImageView: ImageView = findViewById(R.id.emotionImage)

        emotionTextView.text = "\"$emotionText\"입니다"
        emotionImageView.setImageResource(emotionImageResId)
    }
}