package com.example.myapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import android.content.Intent
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 감정 버튼 설정
        val happyButton: ImageButton = findViewById(R.id.happyButton)
        val sadButton: ImageButton = findViewById(R.id.sadButton)
        val neutralButton: ImageButton = findViewById(R.id.neutralButton)
        val excitedButton: ImageButton = findViewById(R.id.excitedButton)
        val angryButton: ImageButton = findViewById(R.id.angryButton)

        // 행복 버튼 클릭 시
        happyButton.setOnClickListener {
            navigateToSecondActivity("행복", R.drawable.happy)
        }

        // 슬픔 버튼 클릭 시
        sadButton.setOnClickListener {
            navigateToSecondActivity("슬픔", R.drawable.sad)
        }

        // 중립 버튼 클릭 시
        neutralButton.setOnClickListener {
            navigateToSecondActivity("평범", R.drawable.neutral)
        }

        // 흥분 버튼 클릭 시
        excitedButton.setOnClickListener {
            navigateToSecondActivity("흥분", R.drawable.excited)
        }

        // 분노 버튼 클릭 시
        angryButton.setOnClickListener {
            navigateToSecondActivity("분노", R.drawable.angry)
        }
    }

    // SecondActivity로 이동하는 함수
    private fun navigateToSecondActivity(emotionText: String, emotionImageResId: Int) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("emotion_text", emotionText)
        intent.putExtra("emotion_image", emotionImageResId)
        startActivity(intent)
    }
}