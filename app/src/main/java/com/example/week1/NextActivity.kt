package com.example.week1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val emotion = intent.getStringExtra("emotion")

        val emotionTextView: TextView = findViewById(R.id.emotionTextView)
        emotionTextView.text = "선택된 감정: $emotion"
    }
}
