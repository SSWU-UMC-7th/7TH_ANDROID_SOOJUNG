package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.ImageView

class MainBannerFragment(private val imageResId: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 레이아웃을 인플레이트하고 그 안에서 이미지뷰를 찾아서 설정
        val view = inflater.inflate(R.layout.fragment_main_banner, container, false)
        val imageView: ImageView = view.findViewById(R.id.bannerImageView)

        // 전달받은 이미지 리소스를 이미지뷰에 설정
        imageView.setImageResource(imageResId)

        return view
    }
}
