package com.example.umc_study

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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
import com.example.umc_study.ui.theme.Umc_studyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        // 이모티콘 ImageButton 설정
        val buttonHappy = findViewById<ImageButton>(R.id.button_happy)
        val buttonGood = findViewById<ImageButton>(R.id.button_good)
        val buttonNormal = findViewById<ImageButton>(R.id.button_normal)
        val buttonAnxious = findViewById<ImageButton>(R.id.button_anxious)
        val buttonAngry = findViewById<ImageButton>(R.id.button_angry)

        // 버튼 클릭 시 새로운 액티비티로 전환
        val intent = Intent(this, EmotionResultActivity::class.java)
        startActivity(intent)


        buttonHappy.setOnClickListener {
            startActivity(intent)
        }

        buttonGood.setOnClickListener {
            startActivity(intent)
        }

        buttonNormal.setOnClickListener {
            startActivity(intent)
        }

        buttonAnxious.setOnClickListener {
            startActivity(intent)
        }

        buttonAngry.setOnClickListener {
            startActivity(intent)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Umc_studyTheme {
        Greeting("Android")
    }
}