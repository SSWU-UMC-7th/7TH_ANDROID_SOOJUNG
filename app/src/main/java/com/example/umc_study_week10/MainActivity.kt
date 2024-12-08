package com.example.umc_study_week10

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.kakao.sdk.user.UserApiClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 카카오 로그인 버튼 찾기
        val kakaoLoginButton = findViewById<ImageView>(R.id.kakaoLoginButton)

        // 2. 로그인 버튼 클릭 이벤트 설정
        kakaoLoginButton.setOnClickListener {
            // 3. 카카오톡 로그인 요청
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
                // 카카오톡 앱이 설치되어 있을 때
                UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                    if (error != null) {
                        Log.e("KakaoLogin", "카카오톡 로그인 실패", error)
                    } else if (token != null) {
                        Log.i("KakaoLogin", "카카오톡 로그인 성공. 토큰: ${token.accessToken}")
                    }
                }
            } else {
                // 카카오톡 앱이 설치되어 있지 않을 때
                UserApiClient.instance.loginWithKakaoAccount(this) { token, error ->
                    if (error != null) {
                        Log.e("KakaoLogin", "카카오 계정 로그인 실패", error)
                    } else if (token != null) {
                        Log.i("KakaoLogin", "카카오 계정 로그인 성공. 토큰: ${token.accessToken}")
                    }
                }
            }
        }
    }
}