package com.example.week6

data class Restaurant(
    val imageResId: Int, // 이미지 리소스 ID
    val name: String,    // 음식점 이름
    val rating: Float,   // 별점
    val deliveryFee: String, // 배달비
    val minOrder: String     // 최소 주문 금액
)
