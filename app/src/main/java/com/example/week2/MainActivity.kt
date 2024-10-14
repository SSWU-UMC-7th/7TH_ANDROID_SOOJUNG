package com.example.week2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView // 이 라인 추가
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // 처음 앱을 실행했을 때 HomeFragment를 표시
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        // BottomNavigationView 항목 선택 이벤트 처리
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val selectedFragment = when (item.itemId) {
                R.id.bottom1 -> HomeFragment()
                R.id.bottom2 -> SearchFragment()
                R.id.bottom3 -> NotificationsFragment()
                R.id.bottom4 -> ProfileFragment()
                else -> null
            }

            // 선택된 프래그먼트로 전환
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit()
            }
            true
        }
    }
}