package com.example.umc_study_week6

data class Property(
    val imageResId: Int,      // 사진
    val location: String,      // 지역명, 숙소 이름
    val rating: String,        // 별점
    val distance: String,      // 거리
    val date: String,          // 날짜
    val price: String          // 금액
)