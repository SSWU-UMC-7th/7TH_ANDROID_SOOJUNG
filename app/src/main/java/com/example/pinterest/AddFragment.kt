package com.example.pinterest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class AddFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 연결할 XML 레이아웃 파일 지정
        return inflater.inflate(R.layout.fragment_add, container, false)
    }
}