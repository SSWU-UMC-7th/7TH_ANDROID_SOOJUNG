package com.example.flo

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class MainBannerVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val imageResIds = listOf(
        R.drawable.img_first_album_default, // 이미지 리소스 ID 임의 설정
        R.drawable.img_first_album_default,
        R.drawable.img_first_album_default,
        R.drawable.img_first_album_default,
        R.drawable.img_first_album_default,
        R.drawable.img_first_album_default,
        R.drawable.img_first_album_default
    )

    override fun getItemCount(): Int = imageResIds.size

    override fun createFragment(position: Int): Fragment {
        return MainBannerFragment(imageResIds[position])
    }
}