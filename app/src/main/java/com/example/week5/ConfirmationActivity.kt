package com.example.week5

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val confirmationTextView: TextView = findViewById(R.id.confirmationTextView)
        val backButton: Button = findViewById(R.id.backButton)

        // MainActivity에서 전달받은 메모 내용 표시
        val memoContent = intent.getStringExtra("memoContent")
        confirmationTextView.text = memoContent

        backButton.setOnClickListener {
            finish() // MainActivity로 돌아가기
        }
    }
}
