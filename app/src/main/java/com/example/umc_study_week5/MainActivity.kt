package com.example.umc_study_week5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_study_week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // View Binding 변수
    private var memoContent: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // View Binding 초기화
        setContentView(binding.root) // setContentView에 binding.root 사용

        binding.nextButton.setOnClickListener {
            val intent = Intent(this, ConfirmActivity::class.java)
            intent.putExtra("memo", binding.memoEditText.text.toString())
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        memoContent = binding.memoEditText.text.toString() // 메모 내용을 저장
    }

    override fun onResume() {
        super.onResume()
        memoContent?.let {
            binding.memoEditText.setText(it) // 저장된 내용을 EditText에 설정
        }
    }

    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this)
            .setMessage("다시 작성하시겠습니까?")
            .setPositiveButton("네") { _, _ ->
                binding.memoEditText.text.clear() // 다시 작성할 경우 EditText 내용 비우기
            }
            .setNegativeButton("아니오") { _, _ ->
                memoContent = null // 다시 작성하지 않겠다고 하면 저장된 변수 비우기
            }
            .show()
    }
}

