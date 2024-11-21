package com.example.week5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var memoEditText: EditText
    private var savedMemo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        memoEditText = findViewById(R.id.memoEditText)
        val nextButton: Button = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            val memoContent = memoEditText.text.toString()
            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("memoContent", memoContent)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // onPause에서 저장된 메모를 EditText에 복원
        if (savedMemo.isNotEmpty()) {
            memoEditText.setText(savedMemo)
        }
    }

    override fun onPause() {
        super.onPause()
        // 현재 작성 중인 내용을 전역 변수에 저장
        savedMemo = memoEditText.text.toString()
    }

    override fun onRestart() {
        super.onRestart()
        // 다이얼로그 표시
        val dialog = AlertDialog.Builder(this)
            .setTitle("메모 계속 작성하기")
            .setMessage("이전에 작성 중이던 메모를 이어서 작성하시겠습니까?")
            .setPositiveButton("네") { _, _ -> }
            .setNegativeButton("아니요") { _, _ ->
                savedMemo = "" // 저장된 내용 비우기
                memoEditText.text.clear()
            }
            .create()
        dialog.show()
    }
}
