package com.example.week6

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // 레이아웃 파일 연결

        // 3번: 데이터 준비
        val restaurants = listOf(
            Restaurant(R.drawable.pic1, "푸라닭 아산온양1호점", 5.0f, "배달비 3,000원", "최소 주문 15,000원"),
            Restaurant(R.drawable.pic2, "BHC 아산신육점", 4.3f, "배달비 3,000원", "최소 주문 18,000원"),
            Restaurant(R.drawable.pic3, "피자스쿨", 4.7f, "배달비 2,000원", "최소 주문 10,000원"),
            Restaurant(R.drawable.pic4, "노랑통닭 용화점", 4.7f, "배달비 3,000원", "최소 주문 18,000원")
        )

        // 4번: RecyclerView 연결
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RestaurantAdapter(restaurants)
    }
}